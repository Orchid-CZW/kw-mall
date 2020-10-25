package com.orchid.kwmall.dao.client;

import com.orchid.kwmall.domain.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface OrderItemMapper {
    int deleteByPrimaryKey(String itemid);

    @Select("insert into order_item (itemid, count, subtotal,id, oid) values (#{itemid}, #{count}, #{subtotal},#{id}, #{oid})")
    void insert(OrderItem record);

    OrderItem selectByPrimaryKey(String itemid);

    List<OrderItem> selectAll();

    int updateByPrimaryKey(OrderItem record);
}