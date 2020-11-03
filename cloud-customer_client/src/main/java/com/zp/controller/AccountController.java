package com.zp.controller;

import com.zp.feign.AccountFeign;
import com.zp.pojo.Admin;
import com.zp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(@RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("type")String type, HttpSession session){
        Object login = accountFeign.login(username, password, type);
        LinkedHashMap<String,Object> hashMap = (LinkedHashMap)login;
        System.out.println(login);

        String result = null;
        if (login == null){
            result = "index";
        }else {
            switch (type) {
                case "user":
                    User user = new User();
                    String idStr = String.valueOf(hashMap.get("id"));
                    long id = Long.parseLong(idStr);
                    String nickname = String.valueOf(hashMap.get("nickname"));
                    user.setId(id);
                    user.setNickname(nickname);
                    session.setAttribute("user", user);
                    result = "index";
                    break;
                case "admin":
                    Admin admin = new Admin();
                    String idAdm = String.valueOf(hashMap.get("id"));
                    long id1 = Long.parseLong(idAdm);
                    String username1 = String.valueOf(hashMap.get("username"));
                    admin.setId(id1);
                    admin.setUsername(username1);
                    session.setAttribute("admin", admin);
                    result = "main";
                    break;
            }
        }
        return result;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }
}
