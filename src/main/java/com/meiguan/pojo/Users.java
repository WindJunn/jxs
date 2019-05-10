package com.meiguan.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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
@Table(name="tb_user")
public class Users implements Serializable {

	@Id
	private String userId;//
	private String pid;//
	private String name;//
	private String username;//
	private String password;//
	private String phone;//
	private String status;//
	private String address;//地址
	private Date createTime;//
	private Date updateTime;//


    @ManyToMany
    @JoinTable(name="tb_user_role",//中间表的名称joinColumns
            //中间表tb_user_role的字段关联tb_user表的主键user_id
            joinColumns={@JoinColumn(name="user_id",referencedColumnName="user_id")},
            //中间表tb_user_role字段关联tb_role表的主键字段role_id
            inverseJoinColumns={@JoinColumn(name="role_id",referencedColumnName="role_id")}
    )
    private Set<Role> roles = new HashSet<Role>(0);
}
