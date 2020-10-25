package com.orchid.kwmall.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 购物车对象
 * @author Orchid
 * @data 2020/6/28 --- 18:54
 */
public class Cart {
    private Map<Integer,CartItem> cartItemMap = new HashMap<>();
    private double total;

    public  void add(CartItem cartItem){
        //获取购物项的商品id
        Integer id = cartItem.getItem().getId();
        //如果购物项集合中已经存在了该购物项则直接在之前的数量上加上这次的数量
        //如果不存在则将该购物项放入购物项集合
        if(cartItemMap.containsKey(id)){
            CartItem cartItem_exit = cartItemMap.get(id);
            cartItem_exit.setCount(cartItem_exit.getCount()+cartItem.getCount());
        }else{
            cartItemMap.put(id,cartItem);
        }
        //重新计算购物车所有商品的总额
        this.total = this.total+cartItem.getSubtotal();
    }

    public void delete(int id){
        //根据id删除购物项集合中对应的购物项
        CartItem remove = cartItemMap.remove(id);
        //重新计算购物车所有商品的总额
        this.total = this.total - remove.getSubtotal();
    }

    public void clear(){
        //清空购物项集合
        cartItemMap.clear();
        //重新计算购物车所有商品的总额
        this.total = 0;
    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public double getTotal() {
        return total;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
