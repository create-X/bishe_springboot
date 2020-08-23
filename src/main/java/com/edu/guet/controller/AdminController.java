package com.edu.guet.controller;

import com.edu.guet.domain.Admin;
import com.edu.guet.domain.Student;
import com.edu.guet.domain.Teacher;
import com.edu.guet.service.AdminService;
import com.edu.guet.util.DeleteException;
import com.edu.guet.util.Result;
import com.edu.guet.util.SaveException;
import com.edu.guet.util.viewException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin")
@CrossOrigin //跨域
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/insertTeacher",method = {RequestMethod.POST})
    @ResponseBody
    public Result insertTeacher(String userId, String departmentId, String teacherName, String password, int studentNum, int surplusNum, String title, String content, String info, String phone, String roleId){
        try {
            Teacher teacher=new Teacher();
            teacher.setTeacherId(userId).setDepartmentid(departmentId).setTeacherName(teacherName)
            .setPassword(password).setStudentNum(studentNum).setSurplusNum(surplusNum)
            .setTitle(title).setContent(content).setStatus("false").setInfo(info).setPhone(phone).setRoleId(roleId);

            adminService.insertTeacher(teacher);
        } catch (SaveException e) {
            e.printStackTrace();
            return Result.fail("保存老师失败");
        }
        return Result.succ("保存老师成功");
    }

    @RequestMapping(value = "/deleteTeacher",method = {RequestMethod.POST})
    @ResponseBody
    public Result deleteTeacher(String userId){
        try {
            adminService.deleteTeacher(userId);
        } catch (DeleteException e) {
            e.printStackTrace();
            return Result.fail("删除老师失败");
        }
        return Result.succ("删除老师成功");
    }

    @RequestMapping(value = "/insertDepartment",method = {RequestMethod.POST})
    @ResponseBody
    public Result insertDepartment(@RequestBody String departmentId, String departmentName){
        try {
            adminService.insertDepartment(departmentId,departmentName);
        } catch (SaveException e) {
            e.printStackTrace();
            return Result.fail("添加专业失败");
        }
        return Result.succ("添加专业成功");
    }

    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    @ResponseBody
    public Result saveStudent(@RequestBody Student student) {
        try {
            adminService.saveStudent(student);
            return Result.succ("保存学生成功");
        } catch (SaveException e) {
            e.printStackTrace();
            return Result.fail("保存学生失败");

        }
    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteStudent(String studentId) {

        try {
            adminService.deleteStudent(studentId);
            return Result.succ("删除学生成功");
        } catch (DeleteException e) {
            e.printStackTrace();
            return Result.fail("删除学生失败");
        }
    }

    @RequestMapping(value = "/viewStudent", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findStudentByPage(Integer currentPage, Integer limit) {


        Map<String, Object> studentByPage = null;
        try {
            studentByPage = adminService.findStudentByPage(currentPage, limit);
            return studentByPage;
        } catch (viewException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/viewTeacher", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findTeacherByPage(Integer currentPage, Integer limit) {


        Map<String, Object> teacherByPage = null;
        try {
            teacherByPage = adminService.findTeacherByPage(currentPage,limit);
            return teacherByPage;
        } catch (viewException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/saveAdmin", method = RequestMethod.POST)
    @ResponseBody
    public Result saveAdmin(@RequestBody Admin admin){
        try {
            adminService.saveAdmin(admin);
            return Result.succ("保存管理员成功");
        } catch (SaveException e) {
            e.printStackTrace();
            return Result.fail("保存管理员失败");
        }

    }

    @RequestMapping(value = "/deleteAdmin", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteAdmin(String adminId){
        try {
            adminService.deleteAdmin(adminId);
            return Result.succ("删除管理员成功");
        } catch (DeleteException e) {
            e.printStackTrace();
            return Result.fail("删除管理员失败");
        }

    }



}
