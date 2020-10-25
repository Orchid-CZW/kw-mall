package com.orchid.kwmall.web.client;

import com.orchid.kwmall.domain.Item;
import com.orchid.kwmall.domain.ItemCat;
import com.orchid.kwmall.service.client.IItemCatService;
import com.orchid.kwmall.service.client.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Orchid
 * @data 2020/6/23 --- 14:49
 */
@Controller
public class IndexController {

    @Autowired
    private IItemCatService itemCatService;
    @Autowired
    private IItemService iItemService;

    /**
     * 首页显示的方法
     * @return
     */
    @GetMapping("/")
    public String index(HttpServletRequest request, Model model){
        //获取所有分类
        List<ItemCat> list = itemCatService.selectAll();
        request.getSession().setAttribute("list",list);

        //获取热门商品
        List<Item> rm_list = iItemService.selectItemsByIflag(1);
        //将数据放入model等价于放入request域
        model.addAttribute("rm_list",rm_list);

        //获取优惠商品
        List<Item> yh_list = iItemService.selectItemsByIflag(2);
        //将数据放入model等价于放入request域
        model.addAttribute("yh_list",yh_list);

        return "index";
    }

    /**
     * 定义统一显示页面的方法
     * @return
     */
    @GetMapping("/{page}")
    public String show(@PathVariable String page){
        return page;
    }

}
