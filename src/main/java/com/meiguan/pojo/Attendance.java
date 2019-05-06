package com.meiguan.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 实体类
 * @author Administrator
 *
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_attendance")
public class Attendance implements Serializable {

	@Id
	private String id;//用户id


	
	private String userId;//
	private Integer state;//0 出勤 1 请假 2 公差 3 迟到 4 早退 5 旷课
	private java.util.Date attendanceTime;//考勤时间

	


	
}
