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

import java.util.List;

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

    /**
     * 根据id删除检查项
     * @param id
     */
    @Override
    public void deleteById(int id) {
        checkItemDao.deleteById(id);
    }

    /**
     * 根据id查询检查项
     * @param id
     * @return
     */
    @Override
    public CheckItem findById(int id) {
        return checkItemDao.findById(id);
    }

    /**
     * 更新检查项
     * @param checkItem
     */
    @Override
    public void update(CheckItem checkItem) {
        checkItemDao.update(checkItem);
    }

    /**
     * 查询所有检查项
     * @return
     */
    @Override
    public List<CheckItem> findAll() {
        return checkItemDao.findAll();
    }
}
