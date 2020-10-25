package com.orchid.kwmall.service.client;

import com.orchid.kwmall.domain.ItemCat;
import java.util.List;

/**
 * @author Orchid
 * @data 2020/6/23 --- 13:45
 */
public interface IItemCatService {

    //获取所有商品分类
    List<ItemCat> selectAll();

    public ItemCat selectByPrimaryKey(int cid);
}
