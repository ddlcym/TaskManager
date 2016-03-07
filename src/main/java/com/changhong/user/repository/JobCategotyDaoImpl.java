package com.changhong.user.repository;

import com.changhong.common.repository.HibernateEntityObjectDao;
import com.changhong.user.domain.Position;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: di
 * Date: 16-2-26
 * Time: 下午1:51
 * To change this template use File | Settings | File Templates.
 */

@Repository("JobCategotyDao")
public class JobCategotyDaoImpl extends HibernateEntityObjectDao implements JobCategotyDao {

    public List<Position> loadAllCategory() {
     StringBuilder builder = new StringBuilder();
     builder.append("from Position");
     return getHibernateTemplate().find(builder.toString());
    }

    public List<Position> findJobByName(String name) {
       Position job = null;
       StringBuilder builder = new StringBuilder();
       builder.append("from Position job");
        if (StringUtils.hasText(name)) {
            builder.append(" where job.name like '%" + name + "%'");
        }
        return  getHibernateTemplate().find(builder.toString());
    }

    public int getJobCategorySize() {
        StringBuilder builder = new StringBuilder();
        builder.append("select count(job.id) from Position job");
        List list =  getHibernateTemplate().find(builder.toString());
        return ((Long)list.get(0)).intValue();    }
}
