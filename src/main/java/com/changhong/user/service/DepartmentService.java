package com.changhong.user.service;

import com.changhong.user.web.facade.dto.DepartmentCategoryDTO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: di
 * Date: 16-2-25
 * Time: 上午10:07
 * To change this template use File | Settings | File Templates.
 */
public interface DepartmentService {

     /**************************************类别部分****************************************/

    List<DepartmentCategoryDTO> obtainAllCategory();

    List<DepartmentCategoryDTO> obtainCategoryByLevel(String level);

    void saveOrUpdateDepartmentCategory(int categoryId, String categoryName,String principleUser, String level,int parentId);

    DepartmentCategoryDTO obtainDepartmentCategoryById(int categoryId);

    void deleteDepartmentCategory(int categoryId);

    boolean obtainCategoryHasDepartments(int categoryId);

    boolean obtainDepartmentExist(int departmentId, String departmentName);

    void changeDepartmentDetails(DepartmentCategoryDTO departmentCategoryDTO);

    /***********************************************************************************************/


}
