package com.orchid.kwmall.web.client;

import com.orchid.kwmall.domain.Cart;
import com.orchid.kwmall.domain.CartItem;
import com.orchid.kwmall.domain.Item;
import com.orchid.kwmall.service.client.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Orchid
 * @data 2020/6/28 --- 19:14
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private IItemService iItemService;

    @RequestMapping("/add")
    public String add(int id, int count, HttpSession session){
        //根据id获取商品信息
        Item item = iItemService.selectByPrimaryKey(id);
        //新建购物项
        CartItem cartItem = new CartItem(item,count);
        //从session中获取购物车
        Cart cart = (Cart)session.getAttribute("cart");
        //将购物项添加到购物车中，如果没有购物车则先创建购物车
        if(cart!=null){
            cart.add(cartItem);
        }else{
            cart = new Cart();
            cart.add(cartItem);
        }
        //将购物车添加到session
        session.setAttribute("cart",cart);
        return "cart";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id, HttpSession session){
        //从session中获取购物车
        Cart cart = (Cart)session.getAttribute("cart");
        //通过id删除商品
        if(cart!=null){
            cart.delete(id);
        }
        return "cart";
    }

    @RequestMapping("/clear")
    public String clear( HttpSession session){
        //从session中获取购物车
        Cart cart = (Cart)session.getAttribute("cart");
        //清空购物车
        if(cart!=null){
            cart.clear();
        }
        return "cart";
    }

}
