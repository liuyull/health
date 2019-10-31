package com.ly.dao;

import com.ly.domain.Emp;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmpDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from t_emp")
    List<Emp> findAll();

    /**
     * 通过查询一个
     * @param id
     * @return
     */
    @Select("select * from t_emp where id = #{id}")
    Emp findById(int id);

    /**
     * 添加
     */
    void insert(Emp emp);

    /**
     * 删除
     */
    void deleteById(int id);

    /**
     * 更新
     */
    void update(Emp emp);
}
