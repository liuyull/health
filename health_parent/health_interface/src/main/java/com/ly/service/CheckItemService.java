package com.ly.service;

import com.github.pagehelper.Page;
import com.ly.domain.CheckItem;
import com.ly.entity.PageResult;
import com.ly.entity.QueryPageBean;

import java.util.List;

public interface CheckItemService {
    void saveCheckItem(CheckItem checkItem);

    PageResult pageQuery(QueryPageBean queryPageBean);

    void deleteById(int id);

    CheckItem findById(int id);

    void update(CheckItem checkItem);

    List<CheckItem> findAll();
}
