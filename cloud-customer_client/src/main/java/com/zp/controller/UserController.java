package com.zp.controller;

import com.zp.feign.UserFeign;
import com.zp.pojo.User;
import com.zp.pojo.UserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFeign userFeign;

    /*  layui数据表格显示无数据，是其一个bug
    * */
    @GetMapping("/findAll")
    @ResponseBody
    public UserResult findAll(@RequestParam("page")int page, @RequestParam("limit")int limit){
        int index = (page-1)*limit;
        UserResult result = new UserResult();
        result.setCode(0);
        result.setCount(userFeign.count());
        result.setMsg("~~~");
        result.setDate(userFeign.findAll(index,limit));
        return result;
    }

    @GetMapping("/goto/{path}")
    public String redirect(@PathVariable("path") String path){
        return path;
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") long id){
        return userFeign.findById(id);
    }

    @GetMapping("/count")
    public int count(){
        return userFeign.count();
    }

    @PostMapping("/save")
    public String save(User user){
        user.setRegisterdate(new Date());
        userFeign.save(user);
        return "redirect:/user/goto/user_manage";
    }

    @PutMapping("/update")
    public void update(User user){
        userFeign.update(user);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        userFeign.deleteById(id);
        return "redirect:/user/goto/user_manage";
    }
}
