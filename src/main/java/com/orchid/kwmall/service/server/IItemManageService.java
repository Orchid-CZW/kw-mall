package com.orchid.kwmall.service.server;

import com.github.pagehelper.PageInfo;
import com.orchid.kwmall.domain.Item;

/**
 * @author Orchid
 * @data 2020/9/30 --- 15:14
 */
public interface IItemManageService {
    PageInfo<Item> selectItems(int pageNum, int pageSize);
    void update(Item item);
}
