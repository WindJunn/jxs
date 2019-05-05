package com.meiguan.dao;

import com.meiguan.pojo.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface UserRoleDao extends JpaRepository<UserRole,String>, JpaSpecificationExecutor<UserRole> {
	
}
