package com.meiguan.service.servieImpl;


import com.meiguan.dao.UserDao;
import com.meiguan.domain.TbUser;
import com.meiguan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add(String name) {
        userDao.add(name);
    }

    @Override
    public void del(Long id) {

        userDao.del(id);
    }

    @Override
    public void update(TbUser user) {

        userDao.update(user);
    }

    @Override
    public TbUser findOne(Long id) {
        return userDao.find(id);
    }

    @Override
    public List<TbUser> findAll() {
        return userDao.findAll();
    }

    @Override
    public Long findSexMan() {
        return userDao.findSexMan();
    }

    @Override
    public Long findSexWoman() {
        return userDao.findSexWoman();
    }

    @Override
    public Long findTotalMan() {
        return userDao.findTotalMan();
    }


    @Autowired
    private JdbcTemplate jdbcTemplate;




}
