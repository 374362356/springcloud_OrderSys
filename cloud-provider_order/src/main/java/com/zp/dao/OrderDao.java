package com.zp.dao;

import com.zp.entity.Order;

import java.util.List;

public interface OrderDao {
    public void save(Order order);

    public List<Order> findAllByUid(int index,int limit,long uid);

    public int countByUid(long uid);

    public List<Order> findBy(int index,int limit);

    public void modifyState(long id);

    public int count();
}
