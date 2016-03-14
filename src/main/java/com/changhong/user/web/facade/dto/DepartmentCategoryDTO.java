package com.changhong.user.web.facade.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: di
 * Date: 16-3-1
 * Time: 下午3:20
 * To change this template use File | Settings | File Templates.
 */
public class DepartmentCategoryDTO implements Serializable {

    private int id = -1;
    private String name;
    private String principleUser;//部门领导
    private String levelType;//部门级别
    private int parentID;//父部门ID;
    private List<String> children;//子部门列表
    private boolean isLoad=false;

    public DepartmentCategoryDTO() {
        }

    public DepartmentCategoryDTO(int id, String name, String principleUser, String levelType, int parentID) {
        this.id = id;
        this.name = name;
        this.principleUser = principleUser;
        this.levelType = levelType;
        this.parentID = parentID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrincipleUser() {
        return principleUser;
    }

    public void setPrincipleUser(String principleUser) {
        this.principleUser = principleUser;
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }


    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }

    public boolean getIsLoad() {
        return isLoad;
    }

    public void setIsLoad(boolean isLoad) {
        this.isLoad = isLoad;
    }

    public boolean getIsBranchNode() {
        if(null != children && children.size()>0 ){
            return true;
        }
        return false;
    }

}
