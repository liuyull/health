package com.ly.service;

import com.ly.domain.Emp;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface EmpService {
    List<Emp> findAll();
    Emp findById(int id);
    void insert(Emp emp);
    void deleteById(int id);
    void update(Emp emp);
}
