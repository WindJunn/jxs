package com.meiguan.dao;

import com.meiguan.pojo.Vedio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author User
 *
 */
public interface VedioDao extends JpaRepository<Vedio,String>, JpaSpecificationExecutor<Vedio> {
	
}
