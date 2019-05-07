package com.meiguan.controller;

import com.meiguan.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("经过认证类:" + username);

        List<GrantedAuthority> grantAuths = new ArrayList();
        grantAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
        /**
         * User:
         * * 参数：
         * 	* 1.用户名
         *  * 2.密码
         *  * 3.认证信息（角色）
         */
        // 去数据库进行查询:
        com.meiguan.pojo.User user = userService.findOne(username);
        if (user != null) {
            return new User(username, user.getPassword(), grantAuths);
        }
        return null;

    }

}
