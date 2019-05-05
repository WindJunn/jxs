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
@Table(name="tb_attendance")
public class Attendance {

	@Id
	private Integer id;//用户id


	
	private Long user_id;//
	private Integer state;//0 出勤 1 请假 2 公差 3 迟到 4 早退 5 旷课
	private java.util.Date attendance_time;//考勤时间

	
	public Integer getId() {		
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Long getUser_id() {		
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Integer getState() {		
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}

	public java.util.Date getAttendance_time() {		
		return attendance_time;
	}
	public void setAttendance_time(java.util.Date attendance_time) {
		this.attendance_time = attendance_time;
	}


	
}
