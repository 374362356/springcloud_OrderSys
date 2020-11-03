package com.zp.controller;

import com.zp.feign.MenuFeign;
import com.zp.pojo.Menu;
import com.zp.pojo.MenuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CustomerHandle {

    @Autowired
    private MenuFeign menuFeign;

    //查出菜品信息
    @GetMapping("/customer/findAll")
    @ResponseBody
    public MenuResult findAll(@RequestParam("page") int page, @RequestParam("limit")int limit){
        int index = (page-1)*limit;
        return menuFeign.findAll(index,limit);
    }

    //提供路径到页面，模板需要渲染才能显示
    @GetMapping("/redirect/{path}")
    public String redirect(@PathVariable("path") String path){
        return path;
    }

    //删除
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        menuFeign.delById(id);
        return "redirect:/redirect/menu_manage";
    }

    //去添加页面，的菜品类型
    @GetMapping("/findType")
    public ModelAndView findType(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_add");
        modelAndView.addObject("list",menuFeign.findType());
        return modelAndView;
    }

    //添加
    @PostMapping("/save")
    public String save(Menu menu){
        menuFeign.save(menu);
        return "redirect:/redirect/menu_manage";
    }

    //去修改
    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_update");
        modelAndView.addObject("menu",menuFeign.findById(id));
        modelAndView.addObject("list",menuFeign.findType());
        return modelAndView;
    }

    //修改
    @PostMapping("/update")
    public String update(Menu menu){
        menuFeign.update(menu);
        return "redirect:/redirect/menu_manage";
    }

}
