package com.changhong.system.repository;

import com.changhong.common.repository.HibernateEntityObjectDao;
import com.changhong.system.domain.DepartmentCategory;
import com.changhong.system.domain.LevelType;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: di
 * Date: 16-2-25
 * Time: 下午6:24
 * To change this template use File | Settings | File Templates.
 */

@Repository("departmentDao")
public class DepartmentDaoImpl extends HibernateEntityObjectDao implements DepartmentDao{

     /**************************************类别部分****************************************/

   public List<DepartmentCategory> loadAllCategory(){

     StringBuilder builder = new StringBuilder();
     builder.append("from DepartmentCategory");
     return getHibernateTemplate().find(builder.toString());
   }


   public List<DepartmentCategory> loadDepartmentCategoryByLevel(String level){
       StringBuilder builder = new StringBuilder();
       builder.append("from DepartmentCategory dpt");
        if (StringUtils.hasText(level)) {
            builder.append(" where dpt.levelType = ?");
        }
       return getHibernateTemplate().find(builder.toString(),LevelType.valueOf(level));

   }


    public List<DepartmentCategory> findDepartmentByName(String name){

       DepartmentCategory department = null;
       StringBuilder builder = new StringBuilder();
       builder.append("from DepartmentCategory dpt");
        if (StringUtils.hasText(name)) {
            builder.append(" where dpt.name like '%" + name + "%'");
        }
        return  getHibernateTemplate().find(builder.toString());
    }



    public int getDepartmentChildrenSize(String name){
        int childrenSize=0;
        StringBuilder builder = new StringBuilder();
        builder.append("from DepartmentCategory dpt");
        if (StringUtils.hasText(name)) {
            builder.append(" where dpt.name like '%" + name + "%'");
        }
        List<DepartmentCategory> list =  getHibernateTemplate().find(builder.toString());
        if(!list.isEmpty()){
             DepartmentCategory dpt=list.get(0);
             List<DepartmentCategory> children= dpt.getAllCategoryBelow();
            childrenSize=children.size();
        }
        return childrenSize;

    }
}
