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
@Table(name="tb_schedule")
public class Schedule {

	@Id
	private Integer id;//


	
	private Integer user_id;//用户id
	private String name;//教员姓名
	private java.util.Date teaching_time;//授课时间
	private String teaching_site;//授课地点
	private String teaching_theme;//授课主题
	private String teaching_state;//授课状态 1.已授课 2.未授课

	
	public Integer getId() {		
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {		
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getName() {		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public java.util.Date getTeaching_time() {		
		return teaching_time;
	}
	public void setTeaching_time(java.util.Date teaching_time) {
		this.teaching_time = teaching_time;
	}

	public String getTeaching_site() {		
		return teaching_site;
	}
	public void setTeaching_site(String teaching_site) {
		this.teaching_site = teaching_site;
	}

	public String getTeaching_theme() {		
		return teaching_theme;
	}
	public void setTeaching_theme(String teaching_theme) {
		this.teaching_theme = teaching_theme;
	}

	public String getTeaching_state() {		
		return teaching_state;
	}
	public void setTeaching_state(String teaching_state) {
		this.teaching_state = teaching_state;
	}


	
}
