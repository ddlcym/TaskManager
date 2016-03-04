package com.changhong.user.web.facade.assember;

import com.changhong.common.repository.EntityLoadHolder;
import com.changhong.user.domain.DepartmentCategory;
import com.changhong.user.web.facade.dto.DepartmentCategoryDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: di
 * Date: 16-3-1
 * Time: 下午4:40
 * To change this template use File | Settings | File Templates.
 */
public class DepartmentWebAssember {

    public static DepartmentCategory toDepartmentDomain( int categoryId, String categoryName, String principleUser,String level,int parentId) {
        DepartmentCategory department = null;
        if (categoryId > 0) {
            department = (DepartmentCategory) EntityLoadHolder.getUserDao().findById(categoryId, DepartmentCategory.class);
            department.setName(categoryName);
            department.setLevelType(level);
            department.setPrincipleUser(principleUser);
        } else {
            department = new DepartmentCategory(categoryName, principleUser,level);
        }

        if (parentId > 0) {
            DepartmentCategory parent = (DepartmentCategory) EntityLoadHolder.getUserDao().findById(parentId, DepartmentCategory.class);
            if(null != parent){
                department.setParent(parent);
            }
        }
        return department;
    }

    public static DepartmentCategoryDTO toDepartmentCategoryDTO(DepartmentCategory department) {
        final int id = department.getId();
        final String name = department.getName();
        final String principleUser = department.getPrincipleUser();
        final String levelType = department.getLevelType();
        final int parentID = (null == department.getParent())?-1:department.getParent().getId();


        DepartmentCategoryDTO dto =  new DepartmentCategoryDTO(id, name, principleUser, levelType, parentID);
        List<String> children = new ArrayList<String>();
        if(department.getChildren() != null) {
            for (DepartmentCategory child : department.getChildren()) {
                children.add(child.getName());
            }
        }
        dto.setChildren(children);
        return dto;
    }

    public static List<DepartmentCategoryDTO> toDepartmentCategoryDTOList(List<DepartmentCategory> departments) {
        List<DepartmentCategoryDTO> dtos = new ArrayList<DepartmentCategoryDTO>();
        if (departments != null) {
            for (DepartmentCategory department : departments) {
                dtos.add(toDepartmentCategoryDTO(department));
            }
        }
        return dtos;
    }
}
