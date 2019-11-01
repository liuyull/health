package com.ly.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.Page;
import com.ly.constant.MessageConstant;
import com.ly.domain.CheckItem;
import com.ly.entity.PageResult;
import com.ly.entity.QueryPageBean;
import com.ly.entity.Result;
import com.ly.service.CheckItemService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/checkItem")
public class CheckItemController {
    @Reference
    private CheckItemService checkItemService;

    /**
     * 新增检查项
     * @param checkItem
     * @return
     */
    @RequestMapping("/save.do")
    public Result saveCheckItem(@RequestBody CheckItem checkItem) {
        Result result = null;
        try {
            checkItemService.saveCheckItem(checkItem);
            result = new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);
        } catch (Exception e) {
            result = new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        }
        return result;
    }

    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return
     */
    @RequestMapping("/pageQuery.do")
    public PageResult pageQuery(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = checkItemService.pageQuery(queryPageBean);
        return pageResult;
    }
    @RequestMapping("/findAll.do")
    public Result findAll(){
        Result result = null;
        try {
            List<CheckItem> checkItemList=checkItemService.findAll();
            result = new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS,checkItemList);
        } catch (Exception e) {
            e.printStackTrace();
            result=new Result(false,MessageConstant.QUERY_CHECKITEM_FAIL);
        }
        return result;
    }

    /**
     *通过id查询
     * @param id
     * @return
     */
    @RequestMapping("/findById.do")
    public CheckItem findById(int id){
        CheckItem checkItem = checkItemService.findById(id);
        return checkItem;
    }
    /**
     * 通过id删除
     * @param id
     * @return
     */
    @RequestMapping("/deleteById.do")
    public Result deleteById(int id){
        Result result = null;
        try {
            checkItemService.deleteById(id);
            result = new Result(true,MessageConstant.DELETE_CHECKITEM_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false,MessageConstant.DELETE_CHECKITEM_FAIL);
        }
        return result;
    }
    @RequestMapping("/update.do")
    public Result update(@RequestBody CheckItem checkItem){
        Result result = null;
        try {
            checkItemService.update(checkItem);
            result = new Result(true,MessageConstant.EDIT_CHECKITEM_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false,MessageConstant.EDIT_CHECKITEM_FAIL);
        }
        return result;
    }
}
