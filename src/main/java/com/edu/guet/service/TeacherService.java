package com.edu.guet.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.guet.domain.Student;
import com.edu.guet.domain.Teacher;

import java.util.List;

public interface TeacherService extends IService<Teacher> {
    void deleteStudent(String userid);

    //老师查看自己的简介
    String viewInfo(String userid);

    //老师要查看所有学生
    List<Student> queryAllStu();

    //老师分页查看所有学生
    List<Student> queryAllStuByPage(Integer currentPage,Integer limit);

    //获得学生总数
    Integer getTotalStu();
}
