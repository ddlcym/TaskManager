package com.changhong.system.repository;

import com.changhong.system.domain.DepartmentCategory;
import com.changhong.system.domain.Role;
import com.changhong.system.domain.RoleType;
import com.changhong.system.domain.User;
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
 * User: Jack Wang
 * Date: 14-11-20
 * Time: 上午8:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/database.xml", "/applicationContext.xml"})
public class UserDaoImplTest extends TestCase {

    @Resource
    SessionFactory sessionFactory;

    @Resource
    UserDaoImpl userDao;

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
    public void testAddUser() {

            List<DepartmentCategory> departments = hibernateTemplate.find("from "+DepartmentCategory.class.getName() +" dpt where dpt.name = ?", "互联网小组");
            if(!departments.isEmpty()){
                DepartmentCategory myDepartment= departments.get(0);
                User newUser = new User("xibo", "password",1400388);
                newUser.setDepartment(myDepartment);
                newUser.grantRole("ROLE_DEVELOPER");
                hibernateTemplate.saveOrUpdate(newUser);
            }

    }


}
