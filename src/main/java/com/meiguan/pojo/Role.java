package com.meiguan.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 实体类
 * @author Users
 *
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_role")
public class Role implements Serializable {

	@Id
	private String id;//主键ID


	
	private String roleName;//角色名称
	private String roleCode;//角色编号
	private String roleDesc;//角色描述
	private String isDefault;//是否默认
	private String creator;//创建人
	private String createDate;//创建时间
	private String modifier;//修改人
	private String modifyDate;//修改时间
	private String delFlag;//删除标记
	private String applicationCode;//系统编号
	private String status;//状态 0-启用，1-禁用

	

	
}
