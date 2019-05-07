package com.meiguan.dao;

import com.meiguan.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author User
 *
 */
public interface UserDao extends JpaRepository<User,String>, JpaSpecificationExecutor<User> {
	
}
