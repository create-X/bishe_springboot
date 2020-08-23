package com.edu.guet.service.impl;

import com.edu.guet.dao.*;
import com.edu.guet.domain.Admin;
import com.edu.guet.domain.Student;
import com.edu.guet.domain.Teacher;
import com.edu.guet.service.AdminService;
import com.edu.guet.util.DeleteException;
import com.edu.guet.util.SaveException;
import com.edu.guet.util.viewException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    UsersMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    StudentMapper studentMapper;

    @Override
    public void insertTeacher(Teacher teacher) throws SaveException {
        userMapper.insertUser(teacher);
        roleMapper.insertRole(teacher);
        teacherMapper.insertTeacher(teacher);
    }

    @Override
    public void deleteTeacher(String userId) throws DeleteException {
        adminMapper.deleteBlacklist(userId);
        roleMapper.deleteRole(userId);
        studentMapper.updateTeacherInStudent(userId);
        teacherMapper.deleteTeacher(userId);
        userMapper.deleteUser(userId);
    }

    @Override
    public void insertDepartment(String departmentId, String departmentName) throws SaveException {
        adminMapper.insertDepartment(departmentId,departmentName);
    }

    @Override
    public void deleteDepartment(String departmentId) {
        teacherMapper.deleteDepartment(departmentId);
        studentMapper.deleteDepartment(departmentId);
        adminMapper.deleteDepartment(departmentId);
    }

    @Override
    public void updateRole(String roleId, String userId) throws DeleteException{
        String oldRoleId=roleMapper.getRoleByUserId(userId);
        if (oldRoleId.equals("R0001")){
            adminMapper.deleteBlacklist(userId);
            roleMapper.deleteRole(userId);
            studentMapper.updateTeacherInStudent(userId);
            teacherMapper.deleteTeacher(userId);
        }
        roleMapper.updateRole(roleId,userId);
        adminMapper.insertAdmin(userId);
    }

    @Override
    public void saveAdmin(Admin admin) throws SaveException {
        adminMapper.saveRole(admin);
        adminMapper.saveUser(admin);
        adminMapper.saveAdmin(admin);
    }

    @Override
    public void deleteAdmin(String adminId) throws DeleteException {
        adminMapper.deleteAdmin(adminId);
        adminMapper.deleteUser(adminId);
        adminMapper.deleteRole(adminId);
    }

    @Override
    public void saveStudent(Student student) throws SaveException {
        studentMapper.saveRole(student);
        studentMapper.saveUser(student);
        studentMapper.saveStudent(student);
    }

    @Override
    public void deleteStudent(String studentId) throws DeleteException {
        studentMapper.deleteStudent(studentId);
        studentMapper.deleteStuAndTe(studentId);
        studentMapper.deleteUser(studentId);
        studentMapper.deleteRole(studentId);
    }

    @Override
    public Map<String, Object> findStudentByPage(Integer currentPage, Integer limit) throws viewException {
        currentPage = (currentPage==null) ? 1 : currentPage;
        limit = (limit==null) ? 5 : limit;
        HashMap<String, Object> map = new HashMap<>();
        //分页处理
        Integer startRow=(currentPage-1)*limit+1;
        Integer endRow=limit*currentPage;
        List<Student> students = studentMapper.findStudentByPage(startRow,endRow);
        //总条数,计算总页数
        Integer total = studentMapper.findStudentTotals();
        Integer totalPages = (total%limit == 0) ? total/limit : (total/limit)+1 ;
        map.put("students",students);
        map.put("total",total);
        map.put("totalPages",totalPages);
        map.put("currentPage",currentPage);
        map.put("limit",limit);
        return map;

    }

    public Map<String,Object> findTeacherByPage(Integer currentPage, Integer limit) throws viewException {
        currentPage = (currentPage==null) ? 1 : currentPage;
        limit = (limit==null) ? 5 : limit;
        HashMap<String, Object> map = new HashMap<>();
        //分页处理
        Integer startRow=(currentPage-1)*limit+1;
        Integer endRow=limit*currentPage;
        List<Teacher> teachers = teacherMapper.findTeacherByPage(startRow, endRow);
        //总条数,计算总页数
        Integer total = teacherMapper.findTeacherTotals();
        Integer totalPages = (total%limit == 0) ? total/limit : (total/limit)+1 ;
        map.put("teachers",teachers);
        map.put("total",total);
        map.put("totalPages",totalPages);
        map.put("currentPage",currentPage);
        map.put("limit",limit);
        return map;

    }


}
