package com.hp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;

@Controller
public class LoginController {

    @Autowired
    private DataSource dataSource;
    @RequestMapping("login")
    @ResponseBody
    public String login(){
        System.out.println(dataSource);
        return "success";
    }
}
