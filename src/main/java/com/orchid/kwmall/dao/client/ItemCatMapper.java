package com.orchid.kwmall.dao.client;

import com.orchid.kwmall.domain.ItemCat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface ItemCatMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(ItemCat record);

    //根据cid获取商品类别
    @Select("select cid, name, status from item_cat where cid = #{cid}")
    @Results({
            @Result(id = true, property = "cid", column = "cid"),
            @Result(property = "name", column = "name"),
            @Result(property = "status", column = "status"),
    })
    ItemCat selectByPrimaryKey(Integer cid);

    //获取所有商品分类
    @Select("select cid, name, status from item_cat")
    @Results({
            @Result(id = true, property = "cid", column = "cid"),
            @Result(property = "name", column = "name"),
            @Result(property = "status", column = "status"),
    })
    List<ItemCat> selectAll();

    int updateByPrimaryKey(ItemCat record);
}