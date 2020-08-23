package com.edu.guet.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("STUDENT")
public class Student implements Serializable {
    private String studentId;
    private Users users;
    private String phone;
    private String status;
    private Teacher teacher;
    private String departmentid;
    private String teacherName;
    private Department department;



}
