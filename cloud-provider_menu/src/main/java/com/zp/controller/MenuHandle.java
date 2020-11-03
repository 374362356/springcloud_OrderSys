package com.zp.controller;

import com.zp.dao.MenuDao;
import com.zp.dao.TypeDao;
import com.zp.entity.Menu;
import com.zp.entity.MenuResult;
import com.zp.entity.MenuType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/menu")
public class MenuHandle {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private TypeDao typeDao;

    @GetMapping("/test")
    public String test(){
        return "menu->"+this.serverPort;
    }

    @GetMapping("/findAll/{index}/{count}")
    public MenuResult t(@PathVariable("index")int index, @PathVariable("count")int count){
        //用这个类封装对应layui格式，参数三设置自动分页的数据数，参数四为data属性
        return new MenuResult(0,"",menuDao.count(),menuDao.findAll(index,count));
    }

    @DeleteMapping("/delete/{id}")
    public void delById(@PathVariable("id") long id){
        menuDao.deleteById(id);
    }

    @GetMapping("/findType")
    public List<MenuType> findType(){
        return typeDao.allType();
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
         menuDao.save(menu);
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") long id){
        return menuDao.findById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Menu menu){
        menuDao.update(menu);
    }
}
