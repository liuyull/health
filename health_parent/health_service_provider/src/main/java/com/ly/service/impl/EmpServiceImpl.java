package com.ly.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ly.dao.EmpDao;
import com.ly.domain.Emp;
import com.ly.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao dao;
    @Override
    public List<Emp> findAll() {
        List<Emp> emps = dao.findAll();
        return emps;
    }

    @Override
    public Emp findById(int id) {
        Emp emp = dao.findById(id);
        return emp;
    }

    @Override
    public void insert(Emp emp) {
        dao.insert(emp);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void update(Emp emp) {
        dao.update(emp);
    }
}
