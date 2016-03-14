package com.changhong.user.service;

import com.alibaba.fastjson.JSONArray;
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

    List<DepartmentCategoryDTO> obtainBranchCategory();

    List<DepartmentCategoryDTO> obtainCategoryByLevel(String level);

    void saveOrUpdateDepartmentCategory(int departmentId, String categoryName,String principleUser, String level,int parentId);

    DepartmentCategoryDTO obtainDepartmentCategoryById(int departmentId);

    void deleteDepartmentCategory(int categoryId);

    boolean obtainDepartmentHasChildren(int departmentId);

    boolean obtainDepartmentExist(int departmentId, String departmentName);

    void changeDepartmentDetails(DepartmentCategoryDTO departmentCategoryDTO);

    List<DepartmentCategoryDTO> obtainDepartmentWithChildren(int departmentId);

    /***********************************************************************************************/
    JSONArray obtainRecommendDepartments(String level);
    JSONArray obtainSubDepartments(int departmentId);


}
