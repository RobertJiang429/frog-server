package com.frog.service;

import com.frog.model.User;
import com.frog.model.dto.PageDto;

/**
 * 定义用户模块的接口
 * @author Robert.Jiang
 * @date 2019年5月21日 下午6:13:53
 */
public interface IUserService {
    PageDto<User> getUser(User user) throws Exception;
	void updateUser(User user) throws Exception;
    void addUser(User user) throws Exception;
    void deleteUser(int userId) throws Exception;
    User login(User user) throws Exception;
}
