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
@Table(name="tb_role")
public class Role {

	@Id
	private String id;//主键ID


	
	private String role_name;//角色名称
	private String role_code;//角色编号
	private String role_desc;//角色描述
	private String is_default;//是否默认
	private String creator;//创建人
	private String create_date;//创建时间
	private String modifier;//修改人
	private String modify_date;//修改时间
	private String del_flag;//删除标记
	private String application_code;//系统编号
	private String status;//状态 0-启用，1-禁用

	
	public String getId() {		
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getRole_name() {		
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_code() {		
		return role_code;
	}
	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}

	public String getRole_desc() {		
		return role_desc;
	}
	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}

	public String getIs_default() {		
		return is_default;
	}
	public void setIs_default(String is_default) {
		this.is_default = is_default;
	}

	public String getCreator() {		
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreate_date() {		
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getModifier() {		
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getModify_date() {		
		return modify_date;
	}
	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}

	public String getDel_flag() {		
		return del_flag;
	}
	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}

	public String getApplication_code() {		
		return application_code;
	}
	public void setApplication_code(String application_code) {
		this.application_code = application_code;
	}

	public String getStatus() {		
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	
}
