package com.zp.feign;

import com.zp.pojo.Order;
import com.zp.pojo.OrderResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(value = "order")
public interface OrderFeign {

    @PostMapping("/order/save")
    public void save(Order order);

    @GetMapping("/order/findAllByUid/{index}/{limit}/{uid}")
    public OrderResult findAllByUid(@PathVariable("index")int index, @PathVariable("limit")int limit, @PathVariable("uid")long uid);

    @GetMapping("/order/findAll/{index}/{limit}")
    public OrderResult findAll(@PathVariable("index")int index, @PathVariable("limit")int limit);

    @GetMapping("/order/modifyState/{id}")
    public OrderResult modifyState(@PathVariable("id")long id);

}
