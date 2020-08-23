package com.edu.guet.dao;

import com.edu.guet.domain.Admin;
import com.edu.guet.util.DeleteException;
import com.edu.guet.util.SaveException;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface AdminMapper {

    void deleteBlacklist(String userId) throws DeleteException;

    void insertDepartment(@Param("departmentId") String departmentId, @Param("departmentName") String departmentName);

    void deleteDepartment(@Param("departmentId") String departmentId);

    void insertAdmin(@Param("userId") String userID);

    void saveAdmin(Admin admin) throws SaveException;
    void saveRole(Admin admin) throws SaveException;
    void saveUser(Admin admin) throws SaveException;
    void deleteAdmin(@Param("adminId") String adminId) throws DeleteException;
    void deleteRole(@Param("adminId") String adminId) throws DeleteException;
    void deleteUser(@Param("adminId") String adminId) throws DeleteException;
}
