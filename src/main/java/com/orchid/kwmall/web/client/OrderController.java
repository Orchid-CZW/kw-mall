package com.orchid.kwmall.web.client;

import com.orchid.kwmall.domain.*;
import com.orchid.kwmall.service.client.IOrderService;
import com.orchid.kwmall.utils.CommonsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/**
 * @author Orchid
 * @data 2020/6/28 --- 21:23
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/create")
    public String createOrders(HttpSession session, Model model){
        //从session中获取用户
        User user = (User)session.getAttribute("u");
        //如果用户不存在则进入登录页面
        if(user==null){
            model.addAttribute("msg","请登录后提交订单");
            return "login";
        }
        //从session中获取购物车
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart!=null){
            //新建订单并设置基本信息
            Orders orders = new Orders();
            orders.setOid(CommonsUtils.getUUID());
            orders.setTotal(cart.getTotal());
            orders.setUid(user.getUid());
            //订单状态为 1 ，即未支付
            orders.setState(1);
            orders.setOrdertime(new Date());
            //添加所有订单项到订单
            for(Map.Entry<Integer,CartItem> entry : cart.getCartItemMap().entrySet()){
                //获取购物项
                CartItem cartItem = entry.getValue();
                //新建订单项
                OrderItem orderItem = new OrderItem();
                //设置订单项id
                orderItem.setItemid(CommonsUtils.getUUID());
                //设置商品数量
                orderItem.setCount(entry.getValue().getCount());
                //设置该购物项总额
                orderItem.setSubtotal(entry.getValue().getSubtotal());
                //设置商品id
                orderItem.setId(entry.getValue().getItem().getId());
                //设置订单id
                orderItem.setOid(orders.getOid());
                //设置商品
                orderItem.setItem(cartItem.getItem());
                //添加订单项到订单
                orders.getOrderItemList().add(orderItem);
            }
            //生成订单
            orderService.createOrders(orders);
            model.addAttribute("orders",orders);
        }
        return "order";
    }

}
