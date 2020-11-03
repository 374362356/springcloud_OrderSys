package com.zp.controller;

import com.zp.dao.OrderDao;
import com.zp.entity.Order;
import com.zp.entity.OrderResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderDao orderDao;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/test")
    public String test(){
        return "Order的端口："+this.serverPort;
    }

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        order.setDate(new Date());
        orderDao.save(order);
    }

    @GetMapping("/findAllByUid/{index}/{limit}/{uid}")
    public OrderResult findAllByUid(@PathVariable("index")int index, @PathVariable("limit")int limit, @PathVariable("uid")long uid){
        OrderResult result = new OrderResult();
        result.setMsg("");
        result.setCount(orderDao.countByUid(uid));
        result.setData(orderDao.findAllByUid(index, limit, uid));
        return result;
    }

    @GetMapping("/count/{uid}")
    public int count(@PathVariable("uid") long uid){
        return orderDao.countByUid(uid);
    }

    @GetMapping("/findAll/{index}/{limit}")
    public OrderResult findAll(@PathVariable("index")int index,@PathVariable("limit")int limit){
        OrderResult result = new OrderResult();
        result.setMsg("");
        result.setCount(orderDao.count());
        result.setData(orderDao.findBy(index, limit));
        return result;
    }

    @GetMapping("/modifyState/{id}")
    public void modifyState(@PathVariable("id") long id){
        orderDao.modifyState(id);
    }
}
