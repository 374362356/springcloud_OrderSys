package cn.zp.dao;

import cn.zp.entity.User;

public interface UserDao {
    public User login(String username,String password);
}
