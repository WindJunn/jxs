package com.meiguan.service;

import com.meiguan.domain.TbAttendance;
import com.meiguan.domain.UserAttendance;

import java.util.List;

public interface AttendanceService {

    void add(String name);

    void del(Long id);

    void update(TbAttendance user);

    TbAttendance findOne(Long id);

    List<UserAttendance> findAll();

    List<UserAttendance> findNotAttendance();
}
