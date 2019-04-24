package com.meiguan.controller;

import com.meiguan.domain.TbUser;
import com.meiguan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public String add(String name){
        userService.add(name);
        return "add sucess";
    }
    @RequestMapping("/del")
    public String del(Long id) {
        userService.del(id);
        return "del success";
    }
    @RequestMapping("/update")
    public String update(){
        TbUser user = new TbUser();
        user.setId(2L);
        user.setName("hahaha");
        userService.update(user);

        return "update success";
    }
    @RequestMapping("/findOne")
    public TbUser findOne(Long id) {
        return userService.findOne(id);
    }

    @RequestMapping("/findAll")
    public List<TbUser> findAll() {
        return userService.findAll();
    }

    @RequestMapping("/findSexMan")
    public Long findSexMan(){
        return userService.findSexMan();
    }

    @RequestMapping("/findSexWoman")
    public Long findSexWoman(){
        return userService.findSexWoman();
    }
    @RequestMapping("/findTotalMan")
    public Long findTotalMan(){
        return userService.findTotalMan();
    }

}
