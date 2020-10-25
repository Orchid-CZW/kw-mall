package com.orchid.kwmall.web.server;

import com.github.pagehelper.PageInfo;
import com.orchid.kwmall.domain.User;
import com.orchid.kwmall.service.server.IUserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Orchid
 * @data 2020/9/29 --- 20:23
 */
@Controller
@RequestMapping("/userManage")
public class UserManageController {

    @Autowired
    private IUserManageService iUserManageService;

    @GetMapping("/query/{pageNum}/{pageSize}")
    public String  queryAllUsers(@PathVariable int pageNum, Model model, @PathVariable int pageSize){
        if(pageSize<1)
            pageSize=1;
        PageInfo<User> pageInfo = iUserManageService.queryAllUsers(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "admin-userlist";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model,@PathVariable String id){
        //通过id删除用户
        iUserManageService.deleteUser(id);
        return "redirect:/userManage/query/1/3";
    }

    @GetMapping("/jumpUpdatePage/{id}")
    public String  jumpUpdatePage(Model model,@PathVariable String id){
        User user = iUserManageService.queryUserById(id);
        model.addAttribute("user",user);
        return "admin-userUpdate";
    }

    @PostMapping("/update")
    public String  updateUser(Model model,String uid,String username, String password, String email, String name, String tel, String gender, String birthday,int state,String code, HttpServletRequest request){
        User user = new User();
        user.setUid(uid);
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);
        user.setTelephone(tel);
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        try {
            user.setBirthday(ft.parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setSex(gender=="true"?"男":"女");
        user.setState(state);
        user.setCode(code);
        iUserManageService.updateUser(user);
        return "redirect:/userManage/query/1/3";
    }
}
