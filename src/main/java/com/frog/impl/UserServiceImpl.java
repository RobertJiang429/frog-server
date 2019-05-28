package com.frog.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.frog.mapper.UserMapper;
import com.frog.model.User;
import com.frog.model.dto.PageDto;
import com.frog.service.IUserService;

/**
 * 
 * @author Robert.Jiang
 * @date 2019年5月21日 下午6:16:56
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserMapper userMapper;


	@Override
	public PageDto<User> getUser(User user) throws Exception {
		Page<User> page = this.userMapper.selectByFuzzyColumn(user);
		List<User> list = page.getResult();

		return new PageDto<>(list.stream().map(a -> modelMapper.map(a, User.class)).collect(Collectors.toList()),
				page.getPageSize(), page.getPageNum(), page.getTotal());
	}

	@Override
	public void updateUser(User user) throws Exception {
		if(findExists(user)) {
			throw new Exception("用户名已存在！");
		}
		int count = this.userMapper.updateByUserId(user);
		if(count == 0) {
			throw new Exception("修改用户信息失败！");
		}
	}

	@Override
	public void addUser(User user) throws Exception {
		if(findExists(user)) {
			throw new Exception("用户名已存在！");
		}
		int count = this.userMapper.insert(user);
		if(count == 0) {
			throw new Exception("新增用户失败！");
		}
	}

	@Override
	public void deleteUser(int userId) throws Exception {
		int count = this.userMapper.deleteByUserId(userId);
		if(count == 0) {
			throw new Exception("删除用户失败！");
		}
	}

	@Override
	public User login(User user) throws Exception {
		User u = this.userMapper.selectByUser(user);
		if(u == null) {
			throw new Exception("用户名或密码错误！");
		} else if(u.getUserStatus() == 0) {
			throw new Exception("账号已失效！");
		}

		return u;
	}
	
	private boolean findExists(User user) throws Exception {
		User tmp = new User();
		tmp.setUserName(user.getUserName());
		List<User> uList = this.getUser(tmp).geteList();
		if(uList != null) {
			return true;
		}
		return false;
	}
}