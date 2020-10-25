package com.orchid.kwmall.service.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orchid.kwmall.dao.server.IUserManageMapper;
import com.orchid.kwmall.domain.User;
import com.orchid.kwmall.service.server.IUserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Orchid
 * @data 2020/9/29 --- 20:30
 */
@Service
@Transactional
public class UserManageServiceImpl implements IUserManageService {

    @Autowired
    private IUserManageMapper iUserManageMapper;

    @Override
    public User queryUserById(String id) {
        return iUserManageMapper.queryUserById(id);
    }

    @Override
    public PageInfo<User> queryAllUsers(int pageNum, int pageSize) {
        //开启分页 设置分页参数
        PageHelper.startPage(pageNum,pageSize);
        //根据分类id查询所有商品
        List<User> list = iUserManageMapper.queryAllUsers();
        //创建分页信息对象
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void deleteUser(String id) {
        iUserManageMapper.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        iUserManageMapper.updateUser(user);
    }


}
