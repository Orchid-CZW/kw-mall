package com.orchid.kwmall.dao.client;

import com.orchid.kwmall.domain.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface ItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    //根据id获取商品信息
    @Select("select * from item where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "marketPrice", column = "market_price"),
            @Result(property = "shopPrice", column = "shop_price"),
            @Result(property = "num", column = "num"),
            @Result(property = "idesc", column = "idesc"),
            @Result(property = "iflag", column = "iflag"),
            @Result(property = "status", column = "status"),
            @Result(property = "created", column = "created"),
            @Result(property = "update", column = "update"),
            @Result(property = "cid", column = "cid")
    })
    Item selectByPrimaryKey(Integer id);

    List<Item> selectAll();

    int updateByPrimaryKey(Item record);

    //查询热门和优惠商品
    @Select("select * from item where iflag=#{iflag} and status=1 order by created desc limit 6")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "marketPrice", column = "market_price"),
            @Result(property = "shopPrice", column = "shop_price"),
            @Result(property = "num", column = "num"),
            @Result(property = "idesc", column = "idesc"),
            @Result(property = "iflag", column = "iflag"),
            @Result(property = "status", column = "status"),
            @Result(property = "created", column = "created"),
            @Result(property = "update", column = "update"),
            @Result(property = "cid", column = "cid")
    })
    List<Item> selectItemsByIflag(int iflag);

    @Select("select * from item where cid=#{cid} and status=1")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "marketPrice", column = "market_price"),
            @Result(property = "shopPrice", column = "shop_price"),
            @Result(property = "num", column = "num"),
            @Result(property = "idesc", column = "idesc"),
            @Result(property = "iflag", column = "iflag"),
            @Result(property = "status", column = "status"),
            @Result(property = "created", column = "created"),
            @Result(property = "update", column = "update"),
            @Result(property = "cid", column = "cid")
    })
    List<Item> selectItemsByCid(int Cid);
}