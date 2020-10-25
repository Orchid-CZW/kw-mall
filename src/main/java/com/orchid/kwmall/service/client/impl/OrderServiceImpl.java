package com.orchid.kwmall.service.client.impl;

import com.orchid.kwmall.dao.client.OrderItemMapper;
import com.orchid.kwmall.dao.client.OrdersMapper;
import com.orchid.kwmall.domain.OrderItem;
import com.orchid.kwmall.domain.Orders;
import com.orchid.kwmall.service.client.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Orchid
 * @data 2020/6/28 --- 21:18
 */
@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Autowired(required = false)
    private OrdersMapper ordersMapper;

    @Autowired(required = false)
    private OrderItemMapper orderItemMapper;

    @Override
    public void createOrders(Orders orders) {
        //添加订单
        ordersMapper.insert(orders);
        //添加所有订单项
        for(OrderItem orderItem : orders.getOrderItemList()){
            orderItemMapper.insert(orderItem);
        }
    }

    @Override
    public void updateOrdersAddress(Orders orders) {
        ordersMapper.updateOrdersAddress(orders);
    }
    @Override
    public void updateOrdersState(int state, String oid) {
        ordersMapper.updateOrdersState(state, oid);
    }

}
