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
 * 实体类
 * @author User
 *
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_article")
public class Article implements Serializable {

	@Id
	private String id;//


	
	private String title;//
	private String author;//作者
	private Date addTime;//添加时间
	private Date updateTime;//
	private String articleContents;//文章内容
	private String articleType;//文章类型  政策，文化，教育，农技，其他
	private String state;//文章状态 审核通过，审核未通过，提交未审核

	


	
}
