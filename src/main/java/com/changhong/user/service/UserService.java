package com.changhong.user.service;

import com.alibaba.fastjson.JSONArray;
import com.changhong.user.web.facade.dto.UserDTO;
import com.changhong.user.web.facade.dto.UserPasswordDTO;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * User: Jack Wang
 * Date: 14-4-9
 * Time: 上午9:20
 */
public interface UserService extends UserDetailsService {

    UserDTO obtainUserById(int userId);

    List<UserDTO> obtainAllUser();

    List<UserDTO> obtainUsers(String name, int startPosition, int pageSize);

    void deleteUserById(int userId);

    int obtainUserSize(String name);

    boolean obtainUserExist(int userId, String username);

    void changeUserDetails(UserDTO userDTO);

    void changeStatusForUser(int userId);

    UserPasswordDTO obtainUserPassword(int userId);

    boolean obtainOldPasswordRight(int userId, String oldPassword);

    void changeUserPassword(int userId, String newPassword);

    JSONArray obtainUserByDepartmentId(int departmentId);

}
