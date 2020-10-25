package com.orchid.kwmall.web.client;

import com.github.pagehelper.PageInfo;
import com.orchid.kwmall.domain.Item;
import com.orchid.kwmall.domain.ItemCat;
import com.orchid.kwmall.service.client.IItemCatService;
import com.orchid.kwmall.service.client.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Orchid
 * @data 2020/6/24 --- 9:06
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private IItemService iItemService;
    @Autowired
    private IItemCatService iItemCatService;

    //商品分类显示
    @RequestMapping("/{cid}/{pageNum}")
    public String selectItemsPageByCid(@PathVariable int cid, @PathVariable int pageNum, Model model){
        //获取分类商品
        PageInfo<Item> pageInfo = iItemService.selectItemsPageByCid(cid,pageNum,6);
        //根据cid获取商品类别
        ItemCat itemCat = iItemCatService.selectByPrimaryKey(cid);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("cat",itemCat);
        return "category";
    }

    //商品详细信息显示
    @RequestMapping("/{id}")
    public String selectByPrimaryKey(@PathVariable int id, Model model){
        //根据id获取商品信息
        Item item = iItemService.selectByPrimaryKey(id);
        model.addAttribute("item",item);
        return "item";
    }

}
