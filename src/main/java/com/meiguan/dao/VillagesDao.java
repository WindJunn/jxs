package com.meiguan.dao;

import com.meiguan.pojo.Villages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface VillagesDao extends JpaRepository<Villages,String>, JpaSpecificationExecutor<Villages> {
	
}
