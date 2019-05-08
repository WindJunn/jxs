package com.meiguan.dao;

import com.meiguan.pojo.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 数据访问接口
 * @author Users
 *
 */
public interface AttendanceDao extends JpaRepository<Attendance,String>, JpaSpecificationExecutor<Attendance> {

    @Query(value = "SELECT * FROM tb_attendance WHERE DATEDIFF(attendance_time,NOW())<=0 AND DATEDIFF(attendance_time,NOW())>-2",nativeQuery = true)
    List findAllAttendance();


}
