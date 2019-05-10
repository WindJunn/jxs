package com.meiguan;

import com.meiguan.dao.RoleDao;
import com.meiguan.dao.UserDao;
import com.meiguan.pojo.Role;
import com.meiguan.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JxsApplicationTests {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Test
    public void contextLoads() {
    }


    @Test
    @Transactional
    @Rollback(false)
    public void test1() {
        Users users = new Users();

        users.setUserId("346");
        users.setUsername("11");
        Role role = new Role();
        role.setRoleName("角色1");

        users.getRoles().add(role);
        role.getUsers().add(users);

        userDao.save(users);
        roleDao.save(role);


    }
}
