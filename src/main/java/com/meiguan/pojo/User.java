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
 * @author User
 *
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_user")
public class User implements Serializable {

	@Id
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
