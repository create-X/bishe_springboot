package com.edu.guet;

import com.alibaba.fastjson.JSONObject;
import com.edu.guet.dao.StudentMapper;
import com.edu.guet.dao.TeacherMapper;
import com.edu.guet.dao.UsersMapper;
import com.edu.guet.domain.Menus;
import com.edu.guet.domain.Student;
import com.edu.guet.domain.Users;
import com.edu.guet.service.TeacherService;
import com.edu.guet.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SubjectTests {
    @Autowired
    private UsersService usersService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private UsersMapper usersMapper;
    @Test
    public void test1(){
        Users login = usersService.login("11001", "11001");
    }



    @Test
    public void test3(){
        List<Menus> menu = usersMapper.getUserMenu("admin");
        System.out.println(JSONObject.toJSONString(menu));

    }

    @Test
    public void test4(){
        String s = teacherMapper.viewInfo("11001");
        System.out.println(s);
    }

    @Test
    public void test5(){
        List<Student> students = studentMapper.queryAllStu();
        students.forEach(System.out::println);
    }
    @Test
    public void test6(){
//        List<Student> students = studentMapper.queryAllStuByPage(2,1);
        Integer integer = studentMapper.selectCount(null);
        System.out.println(integer);
    }


}
