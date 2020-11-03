package com.zp.controller;

import com.zp.dao.UserDao;
import com.zp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandle {

    @Autowired
    private UserDao userDao;

    @GetMapping("/findAll/{index}/{count}")
    public List<User> findAll(@PathVariable("index") int index,@PathVariable("count") int count){
        return userDao.findAll(index,count);
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") long id){
        return userDao.findById(id);
    }

    @GetMapping("/count")
    public int count(){
        return userDao.count();
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        userDao.save(user);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user){
        userDao.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") long id){
        userDao.deleteById(id);
    }
}
