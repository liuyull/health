package com.ly.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ly.dao.CheckItemDao;
import com.ly.domain.CheckItem;
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
    public Page<CheckItem> pageQuery(QueryPageBean queryPageBean) {
        //获取分页条件参数
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        //分页
        PageHelper.startPage(currentPage,pageSize);
        //调用dao完成查询
        Page<CheckItem> checkItemPage = checkItemDao.findByCondition(queryString);
        return checkItemPage;

    }
}
