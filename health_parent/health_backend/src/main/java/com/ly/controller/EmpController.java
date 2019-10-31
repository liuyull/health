package com.ly.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ly.domain.Emp;
import com.ly.service.EmpService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/emp")
@RestController
public class EmpController {
    @Reference
    private EmpService empService;
    @RequestMapping("/findAll.do")
    public List<Emp> findAll(){
        List<Emp> emps = empService.findAll();
        return emps;
    }
    @RequestMapping("/findById.do")
    public Emp findById(int id){
        Emp emp = empService.findById(id);
        return emp;
    }
    @RequestMapping("/save.do")
    public void save(@RequestBody Emp emp){
        empService.insert(emp);
    }
    @RequestMapping("/delById.do")
    public void delById(int id){
        empService.deleteById(id);
    }
    @RequestMapping("/update.do")
    public void update(@RequestBody Emp emp){
        empService.update(emp);
    }
}
