package com.meiguan.dao;

import com.meiguan.pojo.Towns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author User
 *
 */
public interface TownsDao extends JpaRepository<Towns,String>, JpaSpecificationExecutor<Towns> {
	
}
