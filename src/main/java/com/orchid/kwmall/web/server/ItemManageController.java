package com.orchid.kwmall.web.server;

import com.github.pagehelper.PageInfo;
import com.orchid.kwmall.domain.Item;
import com.orchid.kwmall.service.server.IItemManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author Orchid
 * @data 2020/9/30 --- 15:15
 */
@Controller
@RequestMapping("/itemManage")
public class ItemManageController {
    @Autowired
    private IItemManageService iItemManageService;

    @GetMapping("/query/{pageNum}/{pageSize}")
    public String  selectItems(@PathVariable int pageNum, Model model, @PathVariable int pageSize){
        if(pageSize<1)
            pageSize=1;
        PageInfo<Item> pageInfo = iItemManageService.selectItems(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "admin-itemlist";
    }

    @PostMapping("/update")
    public String  update(int id,String name,Double marketPrice,Double shopPrice,int num,String image,String idesc,Byte iflag,Byte status,int cid, Model model){
        Item item = new Item();
        item.setId(id);
        item.setName(name);
        item.setMarketPrice(marketPrice);
        item.setShopPrice(shopPrice);
        item.setNum(num);
        item.setImage(image);
        item.setIdesc(idesc);
        item.setIflag(iflag);
        item.setStatus(status);
        item.setCid(cid);
        item.setUpdated(new Date());
        iItemManageService.update(item);
        return "redirect:/itemManage/query/1/3";
    }
}
