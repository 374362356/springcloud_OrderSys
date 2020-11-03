package cn.zp.controller;

import cn.zp.dao.AdminDao;
import cn.zp.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountHandle {

    @Autowired
    private AdminDao adminDao;
    @Autowired
    private UserDao userDao;

    @PostMapping("/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username")String username,@PathVariable("password") String password,@PathVariable("type") String type){
        Object obj =null;
        switch(type){
            case "user":
                obj = userDao.login(username,password);
                break;
            case "admin":
                obj = adminDao.login(username,password);
                break;
        }
        return obj;
    }

}
