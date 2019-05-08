package com.meiguan.security;

import com.meiguan.pojo.Users;
import com.meiguan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("经过认证类:" + username);
        log.info("用户的用户名: {}", username);
        List<GrantedAuthority> grantAuths = new ArrayList();
        grantAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
        /**
         * Users:
         * * 参数：
         * 	* 1.用户名
         *  * 2.密码
         *  * 3.认证信息（角色）
         */
        // 去数据库进行查询:
        Users users = userService.findOne1(username);
        if (users != null) {
            return new User(username, users.getPassword(), grantAuths);
        }
        return null;

    }

}