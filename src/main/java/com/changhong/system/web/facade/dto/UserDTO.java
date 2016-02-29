package com.changhong.system.web.facade.dto;

import com.changhong.common.utils.CHStringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Jack Wang
 * Date: 14-4-9
 * Time: 上午10:37
 */
public class UserDTO implements Serializable {
    private int id = -1;
    private String account;//登录账号
    private  int   employeeId;//员工编号
    private String email;    //邮件
    private String position;//工作区域：成都、绵阳
    private String username;
    private String password;
    private   int  departmentId;
    private String lastLogin;//最近一次登录时间
    private boolean enabled;
    private List<String> roles;

    public UserDTO() {
        this.password = CHStringUtils.getRandomString(10);
    }

    public UserDTO(int id, String account, int employeeId, String username, String password, boolean enabled) {
        this.id = id;
        this.account = account;
        this.employeeId = employeeId;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public void grantRole(String role) {
        if (roles == null) {
            roles = new ArrayList<String>();
        }
        roles.add(role);
    }

    public boolean getHasRoleAdmin() {
        return hasSpecicalRole("ROLE_ADMIN");
    }

    public boolean getHasRoleAppInfo() {
        return hasSpecicalRole("ROLE_APP_INFO");
    }

    public boolean getHasRoleAppStatistic() {
        return hasSpecicalRole("ROLE_APP_STATISTIC");
    }

    public boolean getHasRoleAppStatus() {
        return hasSpecicalRole("ROLE_APP_STATUS");
    }

    public boolean getHasRoleAppRecommend() {
        return hasSpecicalRole("ROLE_APP_RECOMMEND");
    }

    public boolean hasSpecicalRole(String specicalRole) {
        if (roles == null) {
            return false;
        }
        for (String role : roles) {
            if (role.equals(specicalRole)) {
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
