package com.meiguan.dao;

import com.meiguan.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Users
 *
 */
public interface UserDao extends JpaRepository<Users,String>, JpaSpecificationExecutor<Users> {

    /**
     * 通过名字查找
     * @param username
     * @return
     */
    Users findByUsername(String username);

    @Query(value = "select * from tb_user where username = ? and password = ?",nativeQuery = true)
    Users findByUserNameAndPassword(String username,String password);
	
}
