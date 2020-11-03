package cn.zp.dao;

import cn.zp.entity.Admin;

public interface AdminDao {
    public Admin login(String username,String password);
}
