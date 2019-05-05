package com.meiguan.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name="tb_vedio")
public class Vedio {

	@Id
	private Integer id;//标题


	
	private String title;//
	private String author;//作者
	private java.util.Date add_time;//
	private java.util.Date update_time;//
	private String video_url;//视频地址
	private String type;//视频类型  政策，文化，教育，农技，其他
	private String state;//视频状态 审核通过，审核未通过，提交未审核

	


	
}
