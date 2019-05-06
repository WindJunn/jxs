package com.meiguan.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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
@Table(name="tb_administrator")
public class Administrator implements Serializable {

	@Id
	@Column(name = "id")
	private String id;//

	private String pid;//
	private String name;//
	private String username;//
	private String password;//
	private String phone;//
	private String status;//
	private String address;//地址
	private java.util.Date createTime;//
	private java.util.Date updateTime;//

	

}
