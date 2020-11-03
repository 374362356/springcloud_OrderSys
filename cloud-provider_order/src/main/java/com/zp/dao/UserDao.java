package com.zp.dao;

import com.zp.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll(int index, int count);

    public User findById(long id);

    public int count();

    public void save(User user);

    public void update(User user);

    public void deleteById(long id);
}
