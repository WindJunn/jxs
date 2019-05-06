package com.meiguan.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 评论实体类
 *
 * @author Administrator
 *
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_comment")
public class Comment {

	@Id
	private String id;//


	
	private String articleId;//
	private String content;//评论内容
	private String userId;//

	

	
}
