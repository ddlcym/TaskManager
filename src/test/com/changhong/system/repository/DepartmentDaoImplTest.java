package com.changhong.system.repository;


import com.changhong.user.domain.DepartmentCategory;
import com.changhong.user.repository.DepartmentDao;
import junit.framework.TestCase;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: di
 * Date: 16-2-24
 * Time: 下午1:28
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/database.xml", "/applicationContext.xml"})
public class DepartmentDaoImplTest extends TestCase{

   @Resource
    SessionFactory sessionFactory;

   @Resource
   DepartmentDao departmentDao;

    HibernateTemplate hibernateTemplate;

    @Before
    public void setUp() {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @After
    public void tearDown() {
        hibernateTemplate = null;
    }


   @Test
    public void testAddDepartment(){
//加入一个对象(记录)


            List<DepartmentCategory> list=departmentDao.loadDepartmentCategoryByLevel("LEVEL_SECOND");

			DepartmentCategory department=new DepartmentCategory("STB小组","李林炳","LEVEL_THIRD");
//			department.setName("互联网小组");
//            department.setPrincipleUser("王昆");
//            department.setL("成都");
            if(!list.isEmpty()){
                 DepartmentCategory parent= list.get(0);
                 department.setParent(parent);
            }


            hibernateTemplate.saveOrUpdate(department);
    }

      @Test
    public void testLoadAllCategory(){
        List<DepartmentCategory> list=departmentDao.loadAllCategory();
         for (int i = 0; i < list.size(); i++) {
            DepartmentCategory dpt = list.get(i) ;
             System.out.println(dpt.getId()+dpt.getName());
        }
    }

    @Test
    public void testFindDepartmentByName(){
        List<DepartmentCategory> list=departmentDao.findDepartmentByName("成都");
         for (int i = 0; i < list.size(); i++) {
            DepartmentCategory dpt = list.get(i) ;
             System.out.println(dpt.getId()+dpt.getName());
        }
    }

    @Test
    public void testGetDepartmentChildrenSize(){
        int size=departmentDao.getDepartmentChildrenSize("网络");
        System.out.println("DepartmentChildrenSize  is  "+size);

    }

     @Test
     public void testModifyDepartment(){
         List<DepartmentCategory> list=departmentDao.findDepartmentByName("成都");
         DepartmentCategory dpt=list.get(0);
         dpt.setName("成都研发三部");
         hibernateTemplate.saveOrUpdate(dpt);


    }

      @Test
     public void testDeleteDepartment(){
         List<DepartmentCategory> list=departmentDao.findDepartmentByName("STB小组");
         DepartmentCategory dpt=list.get(0);
         departmentDao.delete(dpt);


    }
}
