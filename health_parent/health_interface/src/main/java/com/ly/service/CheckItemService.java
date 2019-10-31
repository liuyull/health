package com.ly.service;

import com.github.pagehelper.Page;
import com.ly.domain.CheckItem;
import com.ly.entity.PageResult;
import com.ly.entity.QueryPageBean;

public interface CheckItemService {
    void saveCheckItem(CheckItem checkItem);

    PageResult pageQuery(QueryPageBean queryPageBean);
}
