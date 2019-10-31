package com.ly.service;

import com.github.pagehelper.Page;
import com.ly.domain.CheckItem;
import com.ly.entity.QueryPageBean;

public interface CheckItemService {
    void saveCheckItem(CheckItem checkItem);

    Page<CheckItem> pageQuery(QueryPageBean queryPageBean);
}
