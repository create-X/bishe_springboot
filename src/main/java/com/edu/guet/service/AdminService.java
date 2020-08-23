package com.edu.guet.service;


import com.edu.guet.domain.Admin;
import com.edu.guet.domain.Student;
import com.edu.guet.domain.Teacher;
import com.edu.guet.util.DeleteException;
import com.edu.guet.util.SaveException;
import com.edu.guet.util.viewException;

import java.util.Map;


public interface AdminService {
    void insertTeacher(Teacher teacher) throws SaveException;

    void deleteTeacher(String userId) throws DeleteException;

    void insertDepartment(String departmentId, String departmentName) throws SaveException;

    void deleteDepartment(String departmentId);

    void updateRole(String roleId, String userId) throws DeleteException;

    void saveAdmin(Admin admin) throws SaveException;
    void deleteAdmin(String adminId) throws DeleteException;
    void saveStudent(Student student) throws SaveException;
    void deleteStudent(String studentId) throws DeleteException;
    Map<String,Object> findStudentByPage(Integer currentPage, Integer limit) throws viewException;
    Map<String,Object> findTeacherByPage(Integer currentPage, Integer limit) throws viewException;
}
