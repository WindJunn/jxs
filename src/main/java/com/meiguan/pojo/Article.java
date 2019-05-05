package com.meiguan.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

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
@Table(name="tb_article")
public class Article {

	@Id
	private Integer id;//


	
	private String title;//
	private String author;//作者
	private Date add_time;//添加时间
	private Date update_time;//
	private String article_contents;//文章内容
	private String article_type;//文章类型  政策，文化，教育，农技，其他
	private String state;//文章状态 审核通过，审核未通过，提交未审核

	


	
}
