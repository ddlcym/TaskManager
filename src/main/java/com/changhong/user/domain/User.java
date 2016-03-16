package com.changhong.user.domain;

import com.changhong.common.domain.EntityBase;
import org.joda.time.contrib.hibernate.PersistentDateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * User: Jack Wang
 * Date: 14-4-9
 * Time: 上午9:15
 */
public class User extends EntityBase implements UserDetails {
    private String username;//用户真实姓名
    private String account;//登录账号
    private String password;//登录密码
    private String employeeId;//员工编号
    private String email;    //邮件
    private String address;//联系地址
    private PersistentDateTime lastLogin;//最近一次登录时间
    private DepartmentCategory department;//所在部门、小组
    private Position position;    //职位
    private List<Role> roles = new ArrayList<Role>();//用户拥有的角色
    private boolean enabled = true;

    public User() {
    }

    public User(String username,String account,String password,String employeeId,String email,String address) {
        this.username = username;
        this.account = account;
        this.password = password;
        this.employeeId = employeeId;
        this.email = email;
        this.address = address;
        this.enabled = true;
    }

    public void grantRole(String role) {
        if (roles == null) {
            roles = new ArrayList<Role>();
        }
        Role grantRole = new Role(role);
        roles.add(grantRole);
    }

    public boolean hasSpecialRole(String role) {
        if (roles != null) {
            for (Role ownRole : roles) {
                if (ownRole.getAuthority().equals(role)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public PersistentDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(PersistentDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public DepartmentCategory getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentCategory department) {
        this.department = department;
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    /*************************************************GETTER**********************************************************/



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

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        for (Role role : roles) {
            grantedAuthorities.add(role);
        }
        return grantedAuthorities;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
