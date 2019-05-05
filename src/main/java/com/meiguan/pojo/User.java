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
@Table(name="tb_user")
public class User {

	@Id
	private Long id;//


	
	private String username;//用户名
	private String name;//真实姓名
	private String password;//密码，加密存储
	private String pid;//身份证号
	private String phone;//注册手机号
	private java.util.Date created;//创建时间
	private java.util.Date updated;//
	private String health;//健康状态（0死亡 1健康 2一般 3病重 4残疾）
	private String nick_name;//昵称
	private String status;//使用状态（Y正常 N非正常）
	private String head_pic;//头像地址
	private String is_mobile_check;//手机是否验证 （0否  1是）
	private String sex;//性别，1男，2女
	private Integer user_level;//会员等级
	private java.util.Date birthday;//生日
	private java.util.Date last_login_time;//最后登录时间
	private String address;//地址

	
	public Long getId() {		
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {		
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {		
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPid() {		
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPhone() {		
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public java.util.Date getCreated() {		
		return created;
	}
	public void setCreated(java.util.Date created) {
		this.created = created;
	}

	public java.util.Date getUpdated() {		
		return updated;
	}
	public void setUpdated(java.util.Date updated) {
		this.updated = updated;
	}

	public String getHealth() {		
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}

	public String getNick_name() {		
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getStatus() {		
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getHead_pic() {		
		return head_pic;
	}
	public void setHead_pic(String head_pic) {
		this.head_pic = head_pic;
	}

	public String getIs_mobile_check() {		
		return is_mobile_check;
	}
	public void setIs_mobile_check(String is_mobile_check) {
		this.is_mobile_check = is_mobile_check;
	}

	public String getSex() {		
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getUser_level() {		
		return user_level;
	}
	public void setUser_level(Integer user_level) {
		this.user_level = user_level;
	}

	public java.util.Date getBirthday() {		
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	public java.util.Date getLast_login_time() {		
		return last_login_time;
	}
	public void setLast_login_time(java.util.Date last_login_time) {
		this.last_login_time = last_login_time;
	}

	public String getAddress() {		
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	
}
