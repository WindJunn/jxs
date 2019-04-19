package com.meiguan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
public class Test {

    @RequestMapping("/hello")
    public String hello(HashMap<String,Object> map, Model model) {
        model.addAttribute("say", "欢迎");
        map.put("hello", "欢迎进入HTML页面");
        return "index";
    }
}
