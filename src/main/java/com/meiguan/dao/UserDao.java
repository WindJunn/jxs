package com.meiguan.dao;

import com.meiguan.domain.TbUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    @Insert("Insert into tb_user(name) values(#{name})")
    void add(String name);

    @Delete("Delete from tb_user where id = #{id}")
    void del(Long id);

    @Update("update tb_user set name=#{name} where id = #{id}")
    void update(TbUser user);

    @Select("select * from tb_user where id = #{id}")
    TbUser find(Long id);

    @Select("select * from tb_user")
    List<TbUser> findAll();

    @Select("SELECT COUNT(*) FROM tb_user where sex = '男'")
    Long findSexMan();

    @Select("SELECT COUNT(*) FROM tb_user where sex = '女'")
    Long findSexWoman();

    @Select("SELECT COUNT(id) FROM tb_user")
    Long findTotalMan();
}
