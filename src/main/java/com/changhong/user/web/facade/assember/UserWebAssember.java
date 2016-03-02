package com.changhong.user.web.facade.assember;

import com.changhong.common.repository.EntityLoadHolder;
import com.changhong.system.web.facade.dto.UserDTO;
import com.changhong.system.web.facade.dto.UserPasswordDTO;
import com.changhong.user.domain.Role;
import com.changhong.user.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Jack Wang
 * Date: 14-4-9
 * Time: 上午10:58
 */
public class UserWebAssember {

    public static User toUserDomain(UserDTO userDTO) {
        User user = null;
        if(userDTO == null) return null;

        if (userDTO.getId() > 0) {
            user = (User) EntityLoadHolder.getObjectDao().findById(userDTO.getId(), User.class);
            user.setId(userDTO.getId());
            user.setAccount(userDTO.getAccount());
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
        } else {
            user = new User(userDTO.getAccount(), userDTO.getPassword(),userDTO.getEmployeeId());
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

    public static UserDTO toUserDTO(User user) {
        final int id = user.getId();
        final String name = user.getAccount();
        final int employeeID = user.getEmployeeId();
        final String username = user.getUsername();
        final String password = user.getPassword();
        final boolean enabled = user.isEnabled();

        UserDTO dto =  new UserDTO(id, name, employeeID, username, password, enabled);
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
        final String name = user.getAccount();
        final String userName = user.getUsername();
        return new UserPasswordDTO(userId, name, userName);
    }
}
