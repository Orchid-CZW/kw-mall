package com.orchid.kwmall.domain;

/**
 * 购物项对象
 * @author Orchid
 * @data 2020/6/28 --- 18:50
 */
public class CartItem {
    private Item item;
    private int count;
    private double subtotal;

    public CartItem(Item item,int count){
        super();
        this.item = item;
        this.count = count;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSubtotal() {
        this.subtotal = this.item.getShopPrice()*this.count;
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
