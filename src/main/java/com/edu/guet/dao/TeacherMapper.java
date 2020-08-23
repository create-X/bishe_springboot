package com.edu.guet.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.guet.domain.Teacher;
import com.edu.guet.util.DeleteException;
import com.edu.guet.util.SaveException;
import com.edu.guet.util.viewException;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherMapper extends BaseMapper<Teacher> {
    //mybatis-plus实现了一些中低级的sql,高级关联查询的sql需要自己写
    String viewInfo(String userid);

    void insertTeacher(Teacher teacher) throws SaveException;

    void deleteTeacher(@Param("userId")String userId) throws DeleteException;

    void deleteDepartment(@Param("departmentId")String departmentId);

    Integer findTeacherTotals() throws viewException;
    List<Teacher> findTeacherByPage(@Param("startRow") int startRow, @Param("endRow") int endRow) throws viewException;

}
