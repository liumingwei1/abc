package com.taotao.manage.service;

import com.github.abel533.mapper.Mapper;
import com.taotao.manage.mapper.ItemCatMapper;
import com.taotao.manage.pojo.ItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCatService extends BaseService<ItemCat> {
  /*  @Autowired
    protected ItemCatMapper itemCatMapper;

   *//* public List<ItemCat> queryItemCatListByParentId(Long pid) {
        ItemCat record = new ItemCat();
        record.setParentId(pid);
        return this.itemCatMapper.select(record);
    }*//*

    @Override
    public Mapper<ItemCat> getMapper() {
        return this.itemCatMapper;
    }*/
}
