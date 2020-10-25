package com.orchid.kwmall.service.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orchid.kwmall.dao.server.IItemManageMapper;
import com.orchid.kwmall.domain.Item;
import com.orchid.kwmall.service.server.IItemManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author Orchid
 * @data 2020/9/30 --- 15:14
 */
@Service
@Transactional
public class ItemManageServiceImpl implements IItemManageService {

    @Autowired(required = false)
    private IItemManageMapper iItemManageMapper;

    @Override
    public PageInfo<Item> selectItems(int pageNum, int pageSize) {
        //开启分页 设置分页参数
        PageHelper.startPage(pageNum,pageSize);
        //根据分类id查询所有商品
        List<Item> list = iItemManageMapper.selectItems();
        //创建分页信息对象
        PageInfo<Item> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void update(Item item) {
        iItemManageMapper.updateItem(item);
    }
}
