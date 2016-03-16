package com.changhong.user.web.facade.assember;

import com.changhong.common.repository.EntityLoadHolder;
import com.changhong.user.domain.DepartmentCategory;
import com.changhong.user.domain.Position;
import com.changhong.user.domain.Role;
import com.changhong.user.domain.User;
import com.changhong.user.web.facade.dto.UserDTO;
import com.changhong.user.web.facade.dto.UserPasswordDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * User: dangwei.pan
 * Date: 16-3-3
 * Time: 上午10:28
 */

public class UserWebAssember {

    //dto Translate to domain
    public static User toUserDomain(UserDTO userDTO) {

        User user = null;
        if(userDTO == null) return null;

        if (userDTO.getId() > 0) {
            user = (User) EntityLoadHolder.getUserDao().findById(userDTO.getId(), User.class);
            user.setId(userDTO.getId());
            user.setUsername(userDTO.getUsername());  //员工真实姓名
            user.setEmployeeId(userDTO.getEmployeeId());
            user.setAccount(userDTO.getAccount());    //用户登录账号
            user.setPassword(userDTO.getPassword());
            user.setEmail(userDTO.getEmail());
            user.setAddress(userDTO.getAddress());
        } else {
            user = new User(userDTO.getUsername(),userDTO.getAccount(), userDTO.getPassword(),userDTO.getEmployeeId(),userDTO.getEmail(),userDTO.getAddress());
        }

        if(userDTO.getDepartmentId() > 0){
            DepartmentCategory department = new DepartmentCategory();
            department.setId(userDTO.getDepartmentId());
            user.setDepartment(department);
        }

        if(null != userDTO.getPosition()){
            Position position = (Position)EntityLoadHolder.getUserDao().findPositionByName(userDTO.getPosition());
            user.setPosition(position);
        }


        List<String> roles = userDTO.getRoles();
        if (roles != null) {
            if (user.getRoles() != null) {
                user.getRoles().clear();
            }
            for (String role : roles) {
                user.grantRole(role);
            }
        }

        return user;
    }

    //user 轉化為  userDTO
    public static UserDTO toUserDTO(User user) {
        final int id = user.getId();
        final String employeeId = user.getEmployeeId();
        final String username = user.getUsername();
        final String account = user.getAccount();
        final String password = user.getPassword();
        final String Email = user.getEmail();
        final String address = user.getAddress();
        final boolean enabled = user.isEnabled();

        DepartmentCategory department = user.getDepartment();
        Position position =user.getPosition();

        final int departmentId =(null==department)? -1: department.getId();
        final String departmentName =(null==department)?"": department.getFullCategoryPath();
        final String positionName = (null==position)?"":position.getName();

        UserDTO dto =  new UserDTO(id, username,employeeId, account, password,departmentId,departmentName,positionName,Email,address,enabled);
        List<String> roles = new ArrayList<String>();
        if(user.getRoles() != null) {
            for (Role role : user.getRoles()) {
                roles.add(role.getAuthority());
            }
        }
        dto.setRoles(roles);
        return dto;
    }

    public static List<UserDTO> toUserDTOList(List<User> users) {
        List<UserDTO> dtos = new ArrayList<UserDTO>();
        if (users != null) {
            for (User user : users) {
                dtos.add(toUserDTO(user));
            }
        }
        return dtos;
    }

    public static UserPasswordDTO toPasswordDTO(User user) {
        final int userId = user.getId();
        final String userName = user.getAccount();  //账户
        final String name = user.getUsername();  //真实姓名
        return new UserPasswordDTO(userId, name, userName);
    }
}
