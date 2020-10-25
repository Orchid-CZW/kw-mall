package com.orchid.kwmall.service.client.impl;

import com.orchid.kwmall.dao.client.ItemCatMapper;
import com.orchid.kwmall.domain.ItemCat;
import com.orchid.kwmall.service.client.IItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Orchid
 * @data 2020/6/23 --- 13:46
 */
@Service
@Transactional
public class ItemCatServiceImpl implements IItemCatService {

    @Autowired(required = false)
    private ItemCatMapper itemCatMapper;

    @Override
    public List<ItemCat> selectAll() {
        return itemCatMapper.selectAll();
    }

    public ItemCat selectByPrimaryKey(int cid){
        return itemCatMapper.selectByPrimaryKey(cid);
    }

}
