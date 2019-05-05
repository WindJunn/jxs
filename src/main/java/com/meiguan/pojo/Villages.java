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
@Table(name="tb_villages")
public class Villages {

	@Id
	private Long id;//


	
	private String name;//
	private Integer town_id;//

	
	public Long getId() {		
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getTown_id() {		
		return town_id;
	}
	public void setTown_id(Integer town_id) {
		this.town_id = town_id;
	}


	
}
