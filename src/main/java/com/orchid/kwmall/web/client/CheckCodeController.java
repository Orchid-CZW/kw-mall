package com.orchid.kwmall.web.client;

import com.ramostear.captcha.HappyCaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Orchid
 * @data 2020/6/23 --- 17:38
 */
@Controller
public class CheckCodeController {

    @GetMapping("/checkImg")
    public void checkImg(HttpServletRequest request, HttpServletResponse response){
        HappyCaptcha.require(request,response).build().finish();
    }

}
