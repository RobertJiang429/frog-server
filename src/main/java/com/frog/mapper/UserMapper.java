package com.frog.mapper;

import com.github.pagehelper.Page;
import com.frog.model.User;

/**
 * 
 * @author Robert.Jiang
 * @date 2019年5月21日 下午6:16:27
 */
public interface UserMapper {
    int deleteByUserId(Integer id);
    int insert(User user);
    int updateByUserId(User user);
    Page<User> selectByFuzzyColumn(User user);
    User selectByUserId(Integer userId);
    User selectByUser(User user);
}
