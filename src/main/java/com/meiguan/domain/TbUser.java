package com.meiguan.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder(toBuilder = true)
public class TbUser implements Serializable {

    @Tolerate
    public TbUser() {
    }

    private Long id;
    private String username;
    private String name;
    private String password;
    private String pid;
    private String phone;
    private String email;
    private Date created;
    private Date updated;
    private String health;
    private String nickName;
    private String status;
    private String headPic;
    private String isMobileCheck;
    private String sex;
    private Long userLevel;
    private Long points;
    private Date birthday;
    private Date lastLoginTime;
    private String address;
}
