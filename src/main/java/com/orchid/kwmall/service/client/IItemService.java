package com.orchid.kwmall.service.client;

import com.github.pagehelper.PageInfo;
import com.orchid.kwmall.domain.Item;
import java.util.List;

/**
 * @author Orchid
 * @data 2020/6/23 --- 16:25
 */
public interface IItemService {

    List<Item> selectItemsByIflag(int iflag);

    public PageInfo<Item> selectItemsPageByCid(int cid, int pageNum, int pageSize);

    Item selectByPrimaryKey(Integer id);

}
