package com.orchid.kwmall.service.server;

import com.github.pagehelper.PageInfo;
import com.orchid.kwmall.domain.User;

/**
 * @author Orchid
 * @data 2020/9/29 --- 20:29
 */
public interface IUserManageService {
    User queryUserById(String id);
    PageInfo<User> queryAllUsers(int pageNum, int pageSize);
    void deleteUser(String id);
    void updateUser(User user);
}
