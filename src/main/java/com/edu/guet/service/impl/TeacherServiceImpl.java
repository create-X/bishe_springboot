package com.edu.guet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.guet.dao.StudentMapper;
import com.edu.guet.dao.TeacherMapper;
import com.edu.guet.domain.Student;
import com.edu.guet.domain.Teacher;
import com.edu.guet.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void deleteStudent(String userid) {
        //老师这里删除学生不是将学生从数据库删除，而是将学生的选课状态调整为未选上状态
    }

    @Override
    public String viewInfo(String userid) {
        return teacherMapper.viewInfo(userid);
    }

    @Override
    public List<Student> queryAllStu() {
        return studentMapper.queryAllStu();
    }

    @Override
    public List<Student> queryAllStuByPage(Integer currentPage, Integer limit) {
        return studentMapper.queryAllStuByPage(currentPage,limit);
    }

    @Override
    public Integer getTotalStu() {
        return studentMapper.selectCount(null);
    }


}
