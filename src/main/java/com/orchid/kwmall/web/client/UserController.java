package com.orchid.kwmall.web.client;

import com.orchid.kwmall.domain.User;
import com.orchid.kwmall.service.client.IUserService;
import com.orchid.kwmall.utils.CommonsUtils;
import com.ramostear.captcha.HappyCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Orchid
 * @data 2020/6/23 --- 17:21
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 用户登录
     * @return
     */
    @PostMapping("/login")
    public String loginUser(String username, String password, Model model, String code, HttpServletRequest request){
        //第三个参数true则忽略大小写，false则强制大小写一致
        boolean v= HappyCaptcha.verification(request,code,true);
        if(!v){
            model.addAttribute("msg","验证码错误");
            return "login";
        }

        User user = userService.loginUser(username, password);
        if(user == null){
            model.addAttribute("msg","用户名或密码错误");
        }else{
            request.getSession().setAttribute("u",user);
            return "redirect:/";
        }
        return "login";
    }

    /**
     * 用户退出
     * @param session
     * @return
     */
    @RequestMapping("/out")
    public String loginOutUser(HttpSession session){
        session.removeAttribute("u");
        return "redirect:/";
    }

    /**
     * 用户注册
     * @return
     */
    @PostMapping("/register")
    public String registerUser(String username, String password, String email, String name, String tel, String gender, String birthday, HttpServletRequest request){
        User user = new User();
        user.setUid(CommonsUtils.getUUID());
        user.setUsername(username);
        user.setPassword(password);
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        try {
            user.setBirthday(ft.parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setEmail(email);
        user.setName(name);
        user.setSex(gender=="true"?"男":"女");
        user.setTelephone(tel);
        user.setState(0);
        User u = userService.registerUser(user);
        request.getSession().setAttribute("u",u);
        return "redirect:/";
    }

}
