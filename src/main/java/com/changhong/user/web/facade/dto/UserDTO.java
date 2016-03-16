package com.changhong.user.web.facade.dto;

import com.changhong.common.utils.CHStringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: dangwei.pan
 * Date: 16-3-3
 * Time: 上午10:17
 */
public class UserDTO implements Serializable {
    private int id = -1;
    private String username;   //用户真实姓名
    private String employeeId;
    private String account;   //用户登录账号
    private String password;
    private int departmentId;
    private String fullDepartmentName="";//记录员工部门全称：公司.部门。小组
    private String position;
    private String email;
    private String address;
    private boolean enabled;

    private List<String> roles;

    public UserDTO() {
        this.password = CHStringUtils.getRandomString(10);
    }

    public UserDTO(int id, String username, String employeeId, String account, String password, int departmentId,String departmentName,String position,String email,String address,boolean enabled) {
        this.id = id;
        this.username= username;
        this.employeeId = employeeId;
        this.account = account;
        this.password = password;
        this.departmentId = departmentId;
        this.fullDepartmentName = departmentName;
        this.position = position;
        this.email = email;
        this.address = address;
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

    public boolean getHasRoleDepartmentDirector() {
        return hasSpecicalRole("ROLE_DEPARTMENT_DIRECTOR");
    }

    public boolean getHasRoleGroupLeader() {
        return hasSpecicalRole("ROLE_GROUP_LEADER");
    }

    public boolean getHasRoleProductManager() {
        return hasSpecicalRole("ROLE_PRODUCT_MANAGER");
    }

    public boolean getHasRoleSoftwarePM() {
        return hasSpecicalRole("ROLE_SOFTWARE_PM");

    }
    public boolean getHasRoleHardwarePM() {
        return hasSpecicalRole("ROLE_HARDWARE_PM");
    }
    public boolean getHasRoleDeveloper() {
        return hasSpecicalRole("ROLE_DEVELOPER");
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

    /**********************getter和setter方法*********************************************/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

     public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return fullDepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.fullDepartmentName = departmentName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getDepartmentLevel1() {
        String[] levels= fullDepartmentName.split("/");
        if(null != levels  && levels.length>1){
             return levels[1];
        }
        return "无";
    }

    public String getDepartmentLevel2() {
        String[]levels= fullDepartmentName.split("/");
        if(null != levels  && levels.length>2){
             return levels[2];
        }
        return "无";
    }

    public String getDepartmentLevel3() {
        String[] levels= fullDepartmentName.split("/");
        if(null != levels  && levels.length>3){
             return levels[3];
        }
        return "无";
    }

}
