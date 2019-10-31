package com.ly.dao;

import com.github.pagehelper.Page;
import com.ly.domain.CheckItem;
import org.apache.ibatis.annotations.Insert;

public interface CheckItemDao {
    @Insert("insert into t_checkitem values(null,#{code},#{name},#{sex},#{age},#{price},#{type},#{attention},#{remark})")
    public void insertCheckItem(CheckItem checkItem);

    Page<CheckItem> findByCondition(String queryString);
}
