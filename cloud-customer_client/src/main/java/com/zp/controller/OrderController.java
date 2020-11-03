package com.zp.controller;


import com.zp.feign.OrderFeign;
import com.zp.pojo.Menu;
import com.zp.pojo.Order;
import com.zp.pojo.OrderResult;
import com.zp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderFeign orderFeign;

    //订购功能，点击订购则在order表添加一条订购信息
    @GetMapping("/save/{mid}")
    public String save(@PathVariable("mid") long mid, HttpSession session){
        User user = (User)session.getAttribute("user");
        Order order = new Order();
        order.setUser(user);
        Menu menu = new Menu();
        menu.setId(mid);
        order.setMenu(menu);
        orderFeign.save(order);
        return "order";
    }

    @GetMapping("/findAllByUid")
    @ResponseBody
    public OrderResult findAllByUid(@RequestParam("page")int page,@RequestParam("limit")int limit,HttpSession session){
        User user = (User)session.getAttribute("user");
        int index = (page-1)*limit;
        return orderFeign.findAllByUid(index,limit,user.getId());
    }

    @GetMapping("/findAll")
    @ResponseBody
    public OrderResult findAll(@RequestParam("page")int page,@RequestParam("limit")int limit){
        int index = (page-1)*limit;
        return orderFeign.findAll(index, limit);
    }

    @GetMapping("/modifyState/{id}")
    public String modifyState(@PathVariable("id")long id){
        orderFeign.modifyState(id);
        return "redirect:/redirect/order_handler";
    }
}
