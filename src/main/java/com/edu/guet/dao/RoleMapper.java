package com.edu.guet.dao;

import com.edu.guet.domain.Teacher;
import com.edu.guet.util.DeleteException;
import com.edu.guet.util.SaveException;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoleMapper {

    void insertRole(Teacher teacher) throws SaveException;

    void deleteRole(String userId) throws DeleteException;

    void updateRole(@Param("roleId") String roleId, @Param("userId") String userId);

    String getRoleByUserId(@Param("userId") String userId);

}
