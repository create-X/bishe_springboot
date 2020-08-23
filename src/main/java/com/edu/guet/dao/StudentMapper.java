package com.edu.guet.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.guet.domain.Student;
import com.edu.guet.util.DeleteException;
import com.edu.guet.util.SaveException;
import com.edu.guet.util.viewException;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    //查询所有学生
    List<Student> queryAllStu();

    //分页查询所有学生
    List<Student> queryAllStuByPage(@Param("currentPage") Integer currentPage,@Param("limit") Integer limit);

    void updateTeacherInStudent(@Param("userId")String userId);

    void deleteDepartment(@Param("departmentId")String departmentId);

    void saveStudent(Student student) throws SaveException;
    void deleteStudent(@Param("studentId") String studentId) throws DeleteException;
    void saveRole(Student student) throws SaveException;
    void deleteRole(@Param("studentId") String studentId) throws DeleteException;
    Integer findStudentTotals() throws viewException;
    void saveUser(Student student) throws SaveException;
    void deleteUser(@Param("studentId") String studentId) throws DeleteException;
    void deleteStuAndTe(@Param("studentId") String studentId) throws DeleteException;
    List<Student> findStudentByPage(@Param("startRow") int startRow, @Param("endRow") int endRow) throws viewException;
}
