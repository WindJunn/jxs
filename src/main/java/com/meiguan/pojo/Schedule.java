package com.meiguan.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类排班表
 * @author Administrator
 *
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_schedule")
public class Schedule implements Serializable {

	@Id
	private String id;//
	private String userId;//用户id
	private String name;//教员姓名
	private Date teachingTime;//授课时间
	private String teachingSite;//授课地点
	private String teachingTheme;//授课主题
	private String teachingState;//授课状态 1.已授课 2.未授课

	

	
}
