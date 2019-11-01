package com.ly.service;

import com.ly.domain.CheckGroup;
import com.ly.domain.CheckItem;

public interface CheckGroupService {
    void add(CheckGroup checkGroup, Integer[] checkItemIds);
}
