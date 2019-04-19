package com.meiguan.service;

import com.meiguan.domain.TbUser;

import java.util.List;


public interface UserService {

    void add(String name);

    void del(Long id);

    void update(TbUser user);

    TbUser findOne(Long id);

    List<TbUser> findAll();


}
