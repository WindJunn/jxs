package com.meiguan.dao;

import com.meiguan.domain.TbAttendance;
import com.meiguan.domain.UserAttendance;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AttendanceDao {

    @Insert("Insert into tb_attendance(name) values(#{name})")
    void add(String name);

    @Delete("Delete from tb_attendance where id = #{id}")
    void del(Long id);

    @Update("update tb_attendance set name=#{name} where id = #{id}")
    void update(TbAttendance attendance);

    @Select("select * from tb_attendance where id = #{id}")
    TbAttendance find(Long id);

    @Select("select u.*,a.user_id,a.state,a.attendance_time from tb_attendance a LEFT JOIN tb_user u on a.user_id = u.id")
    List<UserAttendance> findAll();

    @Select("select u.*,a.user_id,a.state,a.attendance_time from tb_attendance a LEFT JOIN tb_user u on a.user_id = u.id where a.state = 1")
    List<UserAttendance> findNotAttendance();
}
