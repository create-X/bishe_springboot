package com.edu.guet.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("TEACHER")
public class Teacher implements Serializable {
    private String teacherId;
    private String teacherName;
    private String password;
    private Users users;
    private int studentNum;
    private int surplusNum;
    private String status;
    private Integer total;
    private String departmentid;
    private String departmentName;
    private String title;
    private String content;
    private String info;
    private String phone;
    private Integer confirmNum;

    private String roleId;

    private Roles roles;


}
