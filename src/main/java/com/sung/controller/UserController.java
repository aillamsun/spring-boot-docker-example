package com.sung.controller;

import com.sung.constant.ErrorInfoEnum;
import com.sung.exception.GlobalErrorInfoException;
import com.sung.model.User;
import com.sung.result.ResultBody;
import com.sung.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sungang on 2017/6/29.
 */

@RestController
@RequestMapping("user")
@Api(value = "用户测试", tags = "用户测试", description = "用户测试")
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "添加", httpMethod = "POST", notes = "添加")
    public ResultBody add(@ApiParam(value = " user", name = "user", required = true) @RequestBody User user) throws GlobalErrorInfoException {
        if (null == user.getAccount()) {
            throw new GlobalErrorInfoException(ErrorInfoEnum.USER_ACCOUNT_NOT_NULL);
        }
        user.setId(null);
        userService.insert(user);
        return new ResultBody("OK");
    }


    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "获取所有用户", httpMethod = "GET", notes = "获取所有用户")
    public ResultBody getAll() {
        List<User> users = userService.selectAll();
        if (users.size() == 0) {
            return new ResultBody("暂无用户信息,请先录入数据!");
        }
        return new ResultBody(users);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ApiOperation(value = "获取单个用户", httpMethod = "GET", notes = "获取单个用户")
    public ResultBody getOne(
            @ApiParam(value = " 用户id", name = "id", required = true) @RequestParam Long id
    ) throws GlobalErrorInfoException {
        User user = userService.selectByKey(id);
        if (null == user) {
            throw new GlobalErrorInfoException(ErrorInfoEnum.USER_NOT_FOUNT);
        }
        return new ResultBody(user);
    }


    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "修改用户", httpMethod = "PUT", notes = "修改用户")
    public ResultBody edit(
            @ApiParam(value = " user", name = "user", required = true) @RequestBody User user
    ) throws GlobalErrorInfoException {
        if (null == user.getId()) {
            throw new GlobalErrorInfoException(ErrorInfoEnum.USER_ID_NOT_FOUNT);
        }
        User user2 = userService.selectByKey(user.getId());
        if (null == user2) {
            throw new GlobalErrorInfoException(ErrorInfoEnum.USER_ID_NOT_FOUNT);
        }
        userService.updateByPrimaryKeySelective(user);
        return new ResultBody("OK");
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = " 删除用户", httpMethod = "DELETE", notes = "删除用户")
    public ResultBody delete(
            @ApiParam(value = " 用户id", name = "id", required = true) @RequestParam Long id
    ) throws GlobalErrorInfoException {
        User user = userService.selectByKey(id);
        if (null == user) {
            throw new GlobalErrorInfoException(ErrorInfoEnum.USER_NOT_FOUNT);
        }
        userService.deleteByPrimaryKey(id);
        return new ResultBody("OK");
    }
}
