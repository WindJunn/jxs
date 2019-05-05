package com.meiguan.dao;

import com.meiguan.pojo.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface AdministratorDao extends JpaRepository<Administrator,String>, JpaSpecificationExecutor<Administrator> {
	
}
