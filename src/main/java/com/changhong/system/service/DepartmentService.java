package com.changhong.system.service;

import com.changhong.system.domain.DepartmentCategory;
import org.springframework.web.multipart.MultipartFile;

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

    List<DepartmentCategory> obtainAllCategory();

    List<DepartmentCategory> obtainCategoryByLevel(String level);

    void saveOrUpdateDepartmentCategory(int categoryId, String categoryName, int parentId, MultipartFile iconFile);

    DepartmentCategory obtainDepartmentCategoryById(int categoryId);

    void deleteDepartmentCategory(int categoryId);

    boolean obtainCategoryHasDepartments(int categoryId);

    /***********************************************************************************************/


}
