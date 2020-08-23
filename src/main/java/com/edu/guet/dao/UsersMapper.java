package com.edu.guet.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.guet.domain.Menus;
import com.edu.guet.domain.Teacher;
import com.edu.guet.domain.Users;
import com.edu.guet.util.DeleteException;
import com.edu.guet.util.SaveException;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

//    List<Menus> getMenu(@Param("userid") String userid);

    Menus getMenuById(String id);

    List<Menus> getAllMenu();

    List<Menus> getUserMenu(String userId);

    //修改密码，所有人都在这里修改
    //mp帮我实现了

    //通过id和password查找用户
    Users selectOneUsers(@Param("userid") String userid,@Param("password") String password);

    void insertUser(Teacher teacher) throws SaveException;

    void deleteUser(String userId) throws DeleteException;

}
