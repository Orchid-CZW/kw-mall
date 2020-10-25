package com.orchid.kwmall.service.client.impl;

import com.orchid.kwmall.dao.client.UserMapper;
import com.orchid.kwmall.domain.User;
import com.orchid.kwmall.service.client.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Orchid
 * @data 2020/6/23 --- 17:18
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public User loginUser(String username, String password) {
        return userMapper.loginUser(username,password);
    }

    public User registerUser(User user){
        return userMapper.insert(user);
    }
}
