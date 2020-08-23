package com.edu.guet.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.guet.dao.UsersMapper;
import com.edu.guet.domain.Menus;
import com.edu.guet.domain.Users;
import com.edu.guet.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    QueryWrapper<Users> wrapper;

    @Override
    public Users login(String userId, String password) {
        wrapper = new QueryWrapper<>();
        wrapper.eq("USERID",userId);
        Users usersDB = usersMapper.selectOne(wrapper);
        if(usersDB != null){
            if(password.equals(usersDB.getPassword())){
                return usersDB;
            }else{
                throw new RuntimeException("密码输入错误");
            }
        }else {
            throw new RuntimeException("账号输入错误");
        }
    }

    @Override
    public List<Menus> getUserMenus(String userid) {
        return usersMapper.getUserMenu(userid);
    }

    @Override
    public void updatePassword(String userid,String oldPassword, String newPassword) {
        Users usersDB = usersMapper.selectOneUsers(userid,oldPassword);
        if(usersDB!=null){
            Users users = new Users();
            users.setPassword(newPassword);
            usersMapper.update(users,null);
        }else{
            throw new RuntimeException("旧密码输入错误,请重新输入");
        }
    }
}
