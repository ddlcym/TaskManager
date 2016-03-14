package com.changhong.user.repository;

import com.changhong.common.repository.EntityObjectDao;
import com.changhong.user.domain.DepartmentCategory;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: di
 * Date: 16-2-25
 * Time: 下午6:24
 * To change this template use File | Settings | File Templates.
 */
public interface DepartmentDao extends EntityObjectDao{

     /**************************************类别部分****************************************/

    List<DepartmentCategory> loadAllCategory();

    List<DepartmentCategory> loadDepartmentCategoryByLevel(String level);

    List<DepartmentCategory> findDepartmentByName(String name);

    int getDepartmentChildrenSize(int id);


   /****************************************增、删、改、查************************************************/
   //继承者父类 EntityObjectDao


}
