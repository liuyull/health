package com.ly.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ly.dao.CheckItemDao;
import com.ly.domain.CheckItem;
import com.ly.entity.PageResult;
import com.ly.entity.QueryPageBean;
import com.ly.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    private CheckItemDao checkItemDao;
    @Override
    public void saveCheckItem(CheckItem checkItem) {
        checkItemDao.insertCheckItem(checkItem);
    }

    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        //获取分页条件参数
        //当前页
        Integer currentPage = queryPageBean.getCurrentPage();
        //每页显示条数
        Integer pageSize = queryPageBean.getPageSize();
        //获取分页条件
        String queryString = queryPageBean.getQueryString();
        //分页
        PageHelper.startPage(currentPage,pageSize);
        //调用dao完成查询
        Page<CheckItem> checkItemPage = checkItemDao.findByCondition(queryString);
        PageResult pageResult = new PageResult(checkItemPage.getTotal(), checkItemPage.getResult());
        return pageResult;

    }
}
