package com.hp.controller;

import com.hp.entity.UserInfo;
import com.hp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public String login(){
        System.out.println("mmm");
        return "success";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public UserInfo queryuserById(@PathVariable("id") Integer i){
        System.out.println(i);
        UserInfo userInfo=userService.selectUserById(1);
        System.out.println(userInfo);
        return userInfo;
    }

    @GetMapping("/del/{id}")
    @ResponseBody
    public String deluserById(@PathVariable("id") Integer i){
        System.out.println(i);
        userService.deleteuser(1);

        return "success";
    }

    @GetMapping("/list")
    public String queryAll(Model model){

        List<UserInfo> userInfos = userService.allUser();
        model.addAttribute("userInfos", userInfos);
        return "item";
    }
}
