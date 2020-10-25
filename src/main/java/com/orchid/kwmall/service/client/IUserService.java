package com.orchid.kwmall.service.client;


import com.orchid.kwmall.domain.User;

/**
 * @author Orchid
 * @data 2020/6/23 --- 17:18
 */
public interface IUserService {
    User loginUser(String username, String password);
    User registerUser(User user);
}
