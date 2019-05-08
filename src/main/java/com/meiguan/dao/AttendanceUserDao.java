package com.meiguan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author Users
 *
 */
public interface AttendanceUserDao extends JpaRepository<com.meiguan.pojo.AttendanceUser,String>, JpaSpecificationExecutor<com.meiguan.pojo.AttendanceUser> {
	
}
