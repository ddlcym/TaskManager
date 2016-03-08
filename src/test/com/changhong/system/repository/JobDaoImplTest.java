package com.changhong.system.repository;


import com.changhong.user.domain.Position;
import com.changhong.user.repository.PositionDao;
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
public class JobDaoImplTest extends TestCase{

   @Resource
    SessionFactory sessionFactory;

   @Resource
   PositionDao positionDao;

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
    public void testAddJob(){
//加入一个对象(记录)

			Position job=new Position("测试工程师");
            positionDao.saveOrUpdate(job);
    }

      @Test
    public void testLoadAllCategory(){
        List<Position> list= positionDao.loadAllCategory();
         for (int i = 0; i < list.size(); i++) {
            Position job = list.get(i) ;
             System.out.println(job.getId() + job.getName());
        }
    }



     @Test
     public void testModifyJob(){
         List<Position> list= positionDao.findPosByName("研发工程师");
         Position job=list.get(0);
         job.setName("研发工程师测试");
         positionDao.saveOrUpdate(job);


    }

      @Test
     public void testDeleteJob(){
         List<Position> list= positionDao.findPosByName("测试工程师");
         Position job=list.get(0);
         positionDao.delete(job);
    }
}
