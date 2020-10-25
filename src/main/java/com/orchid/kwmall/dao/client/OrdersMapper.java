package com.orchid.kwmall.dao.client;

import com.orchid.kwmall.domain.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface OrdersMapper {
    int deleteByPrimaryKey(String oid);

    @Select("insert into orders (oid, ordertime, total,state, address, name,telephone, uid) values (#{oid}, #{ordertime}, #{total},#{state}, #{address}, #{name},#{telephone}, #{uid})")
    void insert(Orders record);

    Orders selectByPrimaryKey(String oid);

    List<Orders> selectAll();

    @Select("update orders set address = #{address}, name = #{name}, telephone = #{telephone} where oid = #{oid}")
    void updateOrdersAddress(Orders record);

    @Select("update orders set state = #{state} where oid = #{oid}")
    void updateOrdersState(int state, String oid);
}