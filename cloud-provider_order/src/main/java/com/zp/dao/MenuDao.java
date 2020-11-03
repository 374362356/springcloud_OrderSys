package com.zp.dao;

import com.zp.entity.Menu;

import java.util.List;

public interface MenuDao {
    public List<Menu> findAll(int index, int count);

    public int count();

    public Menu findById(long id);

    public void save(Menu menu);

    public void update(Menu menu);

    public void deleteById(long id);



}
