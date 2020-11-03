package com.zp.feign;

import com.zp.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "user")
public interface UserFeign {

    @GetMapping("/user/findAll/{page}/{limit}")
    public List<User> findAll(@PathVariable("page") int page, @PathVariable("limit") int limit);

    @GetMapping("/user/findById/{id}")
    public User findById(@PathVariable("id") long id);

    @GetMapping("/user/count")
    public int count();

    @PostMapping("/user/save")
    public void save(User user);

    @PutMapping("/user/update")
    public void update(User user);

    @DeleteMapping("/user/delete/{id}")
    public void deleteById(@PathVariable("id") long id);
}
