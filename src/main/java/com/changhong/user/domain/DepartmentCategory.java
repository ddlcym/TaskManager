package com.changhong.user.domain;

import com.changhong.common.domain.EntityBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DepartmentCategory extends EntityBase{

    private String name;
    private String principleUser;//部门领导
    private LevelType levelType;//部门级别
    private DepartmentCategory parent;//父集部门ID  0表示部门，非0表示小组;
    private List<DepartmentCategory> children;//子部门列表

    protected DepartmentCategory() {
    }

    public DepartmentCategory(String name, String principleUser, String levelType) {
        this.name = name;
        this.principleUser = principleUser;
        this.levelType = LevelType.valueOf(levelType);
    }




    public List<DepartmentCategory> getAllCategoryBelow() {
		List<DepartmentCategory> all = new ArrayList<DepartmentCategory>();
		List<DepartmentCategory> children = this.getChildren();
		if (children != null) {
			all.addAll(children);
			Iterator i = children.iterator();
			while (i.hasNext()) {
				DepartmentCategory category = (DepartmentCategory) i.next();
				all.addAll(category.getAllCategoryBelow());
			}
		}
		return all;
	}

    public List<DepartmentCategory> getAllCategoryBelowWithItself() {
		List<DepartmentCategory> all = new ArrayList<DepartmentCategory>();
        all.add(this);
		List<DepartmentCategory> children = this.getChildren();
		if (children != null) {
			all.addAll(children);
			Iterator i = children.iterator();
			while (i.hasNext()) {
				DepartmentCategory category = (DepartmentCategory) i.next();
				all.addAll(category.getAllCategoryBelow());
			}
		}
		return all;
	}

    public List getAllCategoryAbove() {
		List<DepartmentCategory> all = new ArrayList<DepartmentCategory>();
		DepartmentCategory parent = this.getParent();
		if (parent != null) {
			all.addAll(parent.getAllCategoryAbove());
			all.add(parent);
		}
		return all;
	}

    public List<DepartmentCategory> getAllSitesAboveWithItself() {
		List<DepartmentCategory> all = new ArrayList<DepartmentCategory>();
		DepartmentCategory parent = this.getParent();
		if (parent != null) {
			all.addAll(parent.getAllCategoryAbove());
			all.add(parent);
		}
        all.add(this);
		return all;
	}

    public String getFullCategoryPath() {
        List<DepartmentCategory> all = getAllSitesAboveWithItself();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < all.size(); i++) {
            DepartmentCategory site = all.get(i);
            builder.append("/" + site.getName());
        }

        return builder.toString();
    }


    /********************************************************************************************************/


      public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevelType(LevelType levelType) {
        this.levelType = levelType;
    }

    public String getLevelType() {
        return levelType.name();
    }

        public String getPrincipleUser() {
        return principleUser;
    }

    public void setPrincipleUser(String principleUser) {
        this.principleUser = principleUser;
    }

    public DepartmentCategory getParent() {
        return parent;
    }

    public void setParent(DepartmentCategory parent) {
        this.parent = parent;
    }

    public List<DepartmentCategory> getChildren() {
        return children;
    }

    public void setChildren(List<DepartmentCategory> children) {
        this.children = children;
    }
}
