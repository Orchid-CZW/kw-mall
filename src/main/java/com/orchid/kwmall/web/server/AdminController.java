package com.orchid.kwmall.web.server;

import com.orchid.kwmall.domain.Admin;
import com.orchid.kwmall.service.server.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Orchid
 * @data 2020/9/29 --- 17:24
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService iAdminService;

    @PostMapping("/login")
    public String loginUser(String username, String email, String password, Model model, HttpServletRequest request){

        Admin admin = iAdminService.loginUser(username, password);
        if(admin == null){
            model.addAttribute("msg","用户名或密码错误");
        }else{
            request.getSession().setAttribute("admin",admin);
            return "admin-welcome";
        }
        return "admin-login";
    }

}
