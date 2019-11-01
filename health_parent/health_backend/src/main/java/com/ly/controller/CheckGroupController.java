package com.ly.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ly.constant.MessageConstant;
import com.ly.domain.CheckGroup;
import com.ly.domain.CheckItem;
import com.ly.entity.Result;
import com.ly.service.CheckGroupService;
import org.apache.zookeeper.Op;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkGroup")
public class CheckGroupController {
    @Reference
    private CheckGroupService checkGroupService;
    @RequestMapping("/add.do")
    public Result add(@RequestBody CheckGroup checkGroup, Integer[] checkitemIds){
        Result result =null;
        try {
            checkGroupService.add(checkGroup,checkitemIds);
            result = new Result(true, MessageConstant.ADD_CHECKGROUP_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
        }
        return result;
    }
}
