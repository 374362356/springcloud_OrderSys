package com.zp.feign;

import com.zp.pojo.Menu;
import com.zp.pojo.MenuResult;
import com.zp.pojo.MenuType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "menu")
public interface MenuFeign {

    @GetMapping("/menu/findAll/{page}/{limit}")
    public MenuResult findAll(@PathVariable("page") int page, @PathVariable("limit")int limit);

    @DeleteMapping("/menu/delete/{id}")
    public void delById(@PathVariable("id") long id);

    @GetMapping("/menu/findType")
    public List<MenuType> findType();

    @PostMapping("/menu/save")
    public void save(Menu menu);

    @GetMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable("id") long id);

    @PutMapping("/menu/update")
    public void update(Menu menu);

}
