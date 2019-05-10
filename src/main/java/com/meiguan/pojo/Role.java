package com.meiguan.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
	private String roleId;
	//主键ID
	private String roleName;
	//角色名称
	private String roleDesc;
	//角色描述
	private String isDefault;
	//是否默认
	private String status;
	//状态 0-启用，1-禁用

	@ManyToMany(mappedBy="roles")
	private Set<Users> users = new HashSet<>(0);

	
}
