package com.edu.guet.controller;

import com.edu.guet.domain.Result;
import com.edu.guet.domain.Student;
import com.edu.guet.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
@CrossOrigin //解决跨域
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    //查看自己的个人简介
    @GetMapping("/viewInfo")
    public String viewInfo(String userid){
        return teacherService.viewInfo(userid);
    }


    @GetMapping("/findAllStu")
    public List<Student> findAllStu(){
        return teacherService.queryAllStu();
    }

    @GetMapping("/findAllStuByPage")
    public Map<String,Object> findAllStuByPage(Integer currentPage, Integer limit){
        Map<String,Object> maps = new HashMap<>();
        currentPage = (currentPage==null) ? 1 : currentPage;
        limit = (limit==null) ? 1 : limit;
        //分页结果
        List<Student> students = teacherService.queryAllStuByPage(currentPage, limit);
        Integer totals=teacherService.getTotalStu();
        Integer totalPages = (totals%limit == 0) ? totals/limit : (totals/limit)+1 ;
        maps.put("students",students);
        maps.put("currentPage",currentPage);
        maps.put("limit",limit);
        //总页数
        maps.put("totalPages",totalPages);
        //总条数
        maps.put("total",totals);
        return maps;
    }



}
