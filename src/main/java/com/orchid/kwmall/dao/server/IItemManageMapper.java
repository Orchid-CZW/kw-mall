package com.orchid.kwmall.dao.server;

import com.orchid.kwmall.domain.Item;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Orchid
 * @data 2020/9/30 --- 15:12
 */
@Mapper
public interface IItemManageMapper {
    @Select("select * from item")
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
    List<Item> selectItems();

    @Update("update item set name = #{name},market_price = #{marketPrice},shop_price = #{shopPrice},\n" +
            " num = #{num},image = #{image},idesc = #{idesc},iflag = #{iflag},\n" +
            " status = #{status},updated = #{updated},cid = #{cid} where id = #{id}")
    void updateItem(Item item);
}
