package com.orchid.kwmall.service.client.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orchid.kwmall.dao.client.ItemMapper;
import com.orchid.kwmall.domain.Item;
import com.orchid.kwmall.service.client.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Orchid
 * @data 2020/6/23 --- 16:26
 */
@Service
@Transactional
public class ItemServiceImpl implements IItemService {

    @Autowired(required = false)
    private ItemMapper itemMapper;

    @Override
    public List<Item> selectItemsByIflag(int iflag) {
        return itemMapper.selectItemsByIflag(iflag);
    }

    public PageInfo<Item> selectItemsPageByCid(int cid, int pageNum, int pageSize){
        //开启分页 设置分页参数
        PageHelper.startPage(pageNum,pageSize);
        //根据分类id查询所有商品
        List<Item> list = itemMapper.selectItemsByCid(cid);
        //创建分页信息对象
        PageInfo<Item> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Item selectByPrimaryKey(Integer id) {
        return itemMapper.selectByPrimaryKey(id);
    }


}
