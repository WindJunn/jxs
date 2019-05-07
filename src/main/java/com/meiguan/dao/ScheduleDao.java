package com.meiguan.dao;

import com.meiguan.pojo.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author User
 *
 */
public interface ScheduleDao extends JpaRepository<Schedule,String>, JpaSpecificationExecutor<Schedule> {
	
}
