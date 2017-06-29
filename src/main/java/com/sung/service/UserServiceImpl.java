package com.sung.service;

import com.sung.core.service.BaseService;
import com.sung.mapper.UserMapper;
import com.sung.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sungang on 2017/6/29.
 */
@Service
public class UserServiceImpl extends BaseService<User> implements UserService {


    @Autowired
    private UserMapper userMapper;
}
