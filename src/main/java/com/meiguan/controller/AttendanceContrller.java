package com.meiguan.controller;


import com.meiguan.domain.UserAttendance;
import com.meiguan.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceContrller {

    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping("/findAll")
    public List<UserAttendance> findAll() {
        return attendanceService.findAll();
    }


    @RequestMapping("/findNotAttendance")
    public List<UserAttendance> findNotAttendance() {
        return attendanceService.findNotAttendance();
    }
}
