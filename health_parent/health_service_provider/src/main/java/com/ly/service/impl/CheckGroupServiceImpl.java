package com.ly.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ly.dao.CheckGroupDao;
import com.ly.domain.CheckGroup;
import com.ly.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Transactional
@Service(interfaceClass = CheckGroupService.class)
public class CheckGroupServiceImpl implements CheckGroupService {
    @Autowired
    private CheckGroupDao checkGroupDao;
    @Override
    public void add(CheckGroup checkGroup, Integer[] checkItemIds) {
        checkGroupDao.add(checkGroup);
        HashMap<String,Integer> map =new HashMap<String, Integer>();
        if (checkItemIds!=null&&checkItemIds.length>0) {
            for (Integer checkItemId : checkItemIds) {
                map.put("checkGroupId", checkGroup.getId());
                map.put("checkItemId", checkItemId);
                checkGroupDao.setCheckGroupAndCheckItem(map);
            }
        }
    }
}
