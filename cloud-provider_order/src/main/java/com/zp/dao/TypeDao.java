package com.zp.dao;

import com.zp.entity.MenuType;

import java.util.List;

public interface TypeDao {
    public MenuType findById(long id);

    public List<MenuType> allType();
}
