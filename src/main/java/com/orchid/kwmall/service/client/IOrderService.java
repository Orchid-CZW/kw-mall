package com.orchid.kwmall.service.client;

import com.orchid.kwmall.domain.Orders;

/**
 * @author Orchid
 * @data 2020/6/28 --- 21:16
 */
public interface IOrderService {

    public void createOrders(Orders orders);

    public void updateOrdersAddress(Orders orders);

    public void updateOrdersState(int state, String oid);

}
