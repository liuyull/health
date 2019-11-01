package com.ly.dao;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.ly.domain.CheckItem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CheckItemDao {
    /**
     * 新增
     * @param checkItem
     */
    @Insert("insert into t_checkitem values(null,#{code},#{name},#{sex},#{age},#{price},#{type},#{attention},#{remark})")
    public void insertCheckItem(CheckItem checkItem);

    /**
     * 分页条件查询
     * @param queryString
     * @return
     */
    Page<CheckItem> findByCondition(String queryString);

    /**
     * 根据id删除
     * @param id
     */
    @Delete("delete from t_checkitem where id = #{id}")
    void deleteById(int id);

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    @Select("select * from t_checkitem where id = #{id}")
    CheckItem findById(int id);

    /**
     * 更新检查项
     * @param checkItem
     */
    void update(CheckItem checkItem);

    /**
     * 查询所有检查项
     * @return
     */
    @Select("select * from t_checkitem")
    List<CheckItem> findAll();
}
