package com.ly.dao;

import com.ly.domain.CheckGroup;

import java.util.Map;

public interface CheckGroupDao {
    /**
     * 添加检查组
     * @param checkGroup
     */
    void add(CheckGroup checkGroup);

    /**
     * 添加检查项
     */
    void setCheckGroupAndCheckItem(Map map);
}
