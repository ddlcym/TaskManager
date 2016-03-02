package com.changhong.user.service;

import com.changhong.user.domain.DepartmentCategory;
import com.changhong.user.repository.DepartmentDao;
import com.changhong.user.web.facade.assember.DepartmentWebAssember;
import com.changhong.user.web.facade.dto.DepartmentCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: di
 * Date: 16-3-1
 * Time: 下午4:03
 * To change this template use File | Settings | File Templates.
 */
@Service("DepartmentService")
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentDao departmentDao;

    public List<DepartmentCategoryDTO> obtainAllCategory() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<DepartmentCategoryDTO> obtainCategoryByLevel(String level) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }



    public void saveOrUpdateDepartmentCategory(int categoryId, String categoryName, String principleUser, String level,int parentId) {
        //To change body of implemented methods use File | Settings | File Templates.
         DepartmentCategory department = DepartmentWebAssember.toDepartmentDomain(categoryId, categoryName, principleUser, level,parentId);
        departmentDao.saveOrUpdate(department);

        //reset the cache
//        DepartmentCategoryDTO dto = DepartmentWebAssember.toDepartmentCategoryDTO(department);
//        cacheService.resetAppCategoryInCache(dto, false);
    }



    public DepartmentCategoryDTO obtainDepartmentCategoryById(int categoryId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void deleteDepartmentCategory(int categoryId) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean obtainCategoryHasDepartments(int categoryId) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean obtainDepartmentExist(int departmentId, String departmentName) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void changeDepartmentDetails(DepartmentCategoryDTO departmentCategoryDTO) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
