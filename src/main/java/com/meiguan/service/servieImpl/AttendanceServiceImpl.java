package com.meiguan.service.servieImpl;

import com.meiguan.dao.AttendanceDao;
import com.meiguan.domain.TbAttendance;
import com.meiguan.domain.UserAttendance;
import com.meiguan.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceDao attendanceDao;

    @Override
    public void add(String name) {

    }

    @Override
    public void del(Long id) {

    }

    @Override
    public void update(TbAttendance user) {

    }

    @Override
    public TbAttendance findOne(Long id) {
        return null;
    }

    @Override
    public List<UserAttendance> findAll() {
        return attendanceDao.findAll();
    }

    @Override
    public List<UserAttendance> findNotAttendance() {
        return attendanceDao.findNotAttendance();
    }
}
