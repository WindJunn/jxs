package com.meiguan.dao;

import com.meiguan.pojo.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface AttendanceDao extends JpaRepository<Attendance,String>, JpaSpecificationExecutor<Attendance> {
	
}
