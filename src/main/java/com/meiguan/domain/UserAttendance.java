package com.meiguan.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAttendance implements Serializable {

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

    private Long userId;

    private Long state;

    private Date attendanceTime;
}

