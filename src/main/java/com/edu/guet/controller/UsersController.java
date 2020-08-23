package com.edu.guet.controller;

import com.edu.guet.domain.Menus;
import com.edu.guet.domain.Result;
import com.edu.guet.domain.Users;
import com.edu.guet.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public Result login(@RequestBody Users users){
        Result result = new Result();
        try{
            usersService.login(users.getUserid(),users.getPassword());
            result.setMsg("登录成功");
        }catch (Exception e){
            result.setMsg(e.getMessage()).setStatus(false).setCode(400);
        }
        return result;
    }

    @GetMapping("/getUserMenus")
    public List<Menus> getMenus(String userid){
        return usersService.getUserMenus(userid);
    }

    @PostMapping("/updatePass")
    @ResponseBody
    public Result updatePass(String userid,String oldPassword,String newPassword){
        Result result = new Result();
        try {
            usersService.updatePassword(userid,oldPassword, newPassword);
            result.setMsg("修改成功");
        }catch (Exception e){
            result.setMsg(e.getMessage()).setStatus(false).setCode(400);
        }
        return result;
    }



}
