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
        Page<CheckItem> checkItemPage = null;
        try {
            checkItemPage = checkItemService.pageQuery(queryPageBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageResult pageResult = new PageResult(checkItemPage.getTotal(), checkItemPage.getResult());
        return pageResult;
    }
}
