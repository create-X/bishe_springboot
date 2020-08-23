package com.edu.guet.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.guet.domain.Menus;
import com.edu.guet.domain.Users;

import java.util.List;

public interface UsersService extends IService<Users> {
    Users login(String userId,String password);

    List<Menus> getUserMenus(String userid);

    void updatePassword(String userid,String oldPassword,String newPassword);
}
