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
 * @author Administrator
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

	private String username;//用户名
	private String name;//真实姓名
	private String password;//密码，加密存储
	private String pid;//身份证号
	private String phone;//注册手机号
	private Date created;//创建时间
	private Date updated;//
	private String health;//健康状态（0死亡 1健康 2一般 3病重 4残疾）
	private String nickName;//昵称
	private String status;//使用状态（Y正常 N非正常）
	private String headPic;//头像地址
	private String isMobileCheck;//手机是否验证 （0否  1是）
	private String sex;//性别，1男，2女
	private java.util.Date birthday;//生日
	private java.util.Date lastLoginTime;//最后登录时间
	private String address;//地址

	

	
}
