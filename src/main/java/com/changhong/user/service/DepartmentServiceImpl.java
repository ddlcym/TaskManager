package com.changhong.user.service;

import com.changhong.user.domain.DepartmentCategory;
import com.changhong.user.repository.DepartmentDao;
import com.changhong.user.web.facade.assember.DepartmentWebAssember;
import com.changhong.user.web.facade.dto.DepartmentCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: di
 * Date: 16-3-1
 * Time: 下午4:03
 * To change this template use File | Settings | File Templates.
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentDao departmentDao;

    public List<DepartmentCategoryDTO> obtainAllCategory() {
//        System.out.print("departmentDao is "+((null==departmentDao)?"null":"not null"));
        List<DepartmentCategory> departments = departmentDao.loadAllCategory();
        return DepartmentWebAssember.toDepartmentCategoryDTOList(departments);
    }

    public List<DepartmentCategoryDTO> obtainCategoryByLevel(String level) {
        List<DepartmentCategory> departments = departmentDao.loadDepartmentCategoryByLevel(level);
        return DepartmentWebAssember.toDepartmentCategoryDTOList(departments);
    }

    public void saveOrUpdateDepartmentCategory(int departmentId, String categoryName, String principleUser, String level,int parentId) {
        //To change body of implemented methods use File | Settings | File Templates.
         DepartmentCategory department = DepartmentWebAssember.toDepartmentDomain(departmentId, categoryName, principleUser, level,parentId);
         departmentDao.saveOrUpdate(department);

    }

    public DepartmentCategoryDTO obtainDepartmentCategoryById(int departmentId) {
        DepartmentCategory department = (DepartmentCategory)departmentDao.findById(departmentId,DepartmentCategory.class);
        return DepartmentWebAssember.toDepartmentCategoryDTO(department);  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void deleteDepartmentCategory(int departmentId) {
        if(departmentId <= 0 )return;

        DepartmentCategory department = (DepartmentCategory)departmentDao.findById(departmentId,DepartmentCategory.class);
         if(null  != department){
             departmentDao.delete(department);
         }
    }

    public boolean obtainDepartmentHasChildren(int departmentId) {

         if(departmentDao.getDepartmentChildrenSize(departmentId)>0)  {
             return true;
         }
        return false;
    }

    public boolean obtainDepartmentExist(int departmentId, String departmentName) {
        boolean isExist=false;
        if(departmentId > 0 && StringUtils.hasText(departmentName)){
             DepartmentCategory department = (DepartmentCategory)departmentDao.findById(departmentId,DepartmentCategory.class);
             if(department.getName().equals(departmentName)) {
                   isExist=true;
             }
        }
        return isExist;
    }

    public void changeDepartmentDetails(DepartmentCategoryDTO departmentCategoryDTO) {
    }
}
