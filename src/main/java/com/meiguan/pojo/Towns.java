package com.meiguan.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_towns")
public class Towns {

	@Id
	private Integer id;//


	
	private String name;//
	private String county;//

	
	public Integer getId() {		
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCounty() {		
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}


	
}
