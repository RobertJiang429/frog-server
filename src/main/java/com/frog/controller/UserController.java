package com.frog.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.frog.model.User;
import com.frog.model.dto.PageDto;
import com.frog.service.IUserService;
import com.frog.utils.PageContext;
import com.frog.utils.UnifiedCode;
import com.frog.utils.UnifiedResponse;

/**
 * 
 * @author Robert.Jiang
 * @date 2019年5月21日 下午6:17:29
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UnifiedResponse<User> login(@RequestBody User user) {
        try {
            return new UnifiedResponse<>(UnifiedCode.OK.getCode(), this.userService.login(user), null);
        } catch (Exception e) {
            e.printStackTrace();
            return new UnifiedResponse<>(UnifiedCode.SYS_ERR.getCode(), null, e.getMessage());
        }
    }

    @RequestMapping(value = "/user/addUser", method = RequestMethod.POST)
    public UnifiedResponse<String> addUser(@RequestBody User user){
        try{
            userService.addUser(user);
            return new UnifiedResponse<>(UnifiedCode.OK.getCode(), "新增用户成功！", null);
        } catch (Exception e){
            e.printStackTrace();
            return new UnifiedResponse<>(UnifiedCode.SYS_ERR.getCode(), null, e.getMessage());
        }
    }

    @RequestMapping(value = "/user/updateUser", method = RequestMethod.POST)
    public UnifiedResponse<String> updateUser(@RequestBody User user){
        try {
            userService.updateUser(user);
            return new UnifiedResponse<>(UnifiedCode.OK.getCode(), "修改用户信息成功!", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new UnifiedResponse<>(UnifiedCode.SYS_ERR.getCode(), null, e.getMessage());
        }
    }

    @RequestMapping(value = "/user/deleteUser", method = RequestMethod.POST)
    public UnifiedResponse<String> deleteUser(@RequestBody Integer userId){
        try {
            userService.deleteUser(userId);
            return new UnifiedResponse<>(UnifiedCode.OK.getCode(), "删除用户成功！", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new UnifiedResponse<>(UnifiedCode.SYS_ERR.getCode(), null, e.getMessage());
        }
    }

    @RequestMapping(value = "/user/getUser", method = RequestMethod.POST)
    public UnifiedResponse<PageDto<User>> getUser(@RequestBody User user){
        PageHelper.startPage(PageContext.getPageIndex(), PageContext.getPageSize());
        try {
        	PageDto<User> page = userService.getUser(user);
            return new UnifiedResponse<>(UnifiedCode.OK.getCode(), page, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new UnifiedResponse<>(UnifiedCode.SYS_ERR.getCode(), null, e.getMessage());
        }
    }
}