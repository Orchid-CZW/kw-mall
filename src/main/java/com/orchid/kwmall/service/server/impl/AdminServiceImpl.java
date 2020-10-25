package com.orchid.kwmall.service.server.impl;

import com.orchid.kwmall.dao.server.IAdminMapper;
import com.orchid.kwmall.domain.Admin;
import com.orchid.kwmall.service.server.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Orchid
 * @data 2020/9/29 --- 17:38
 */
@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private IAdminMapper iAdminMapper;

    @Override
    public Admin loginUser(String username, String password) {
        return iAdminMapper.loginAdmin(username,password);
    }
}
