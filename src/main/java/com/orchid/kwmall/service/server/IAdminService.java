package com.orchid.kwmall.service.server;

import com.orchid.kwmall.domain.Admin;

/**
 * @author Orchid
 * @data 2020/9/29 --- 17:38
 */
public interface IAdminService {
    Admin loginUser(String username, String password);
}
