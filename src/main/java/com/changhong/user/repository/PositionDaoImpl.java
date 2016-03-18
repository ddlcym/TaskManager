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

@Repository("PositionDao")
public class PositionDaoImpl extends HibernateEntityObjectDao implements PositionDao {

    public List<Position> loadAllCategory() {
     StringBuilder builder = new StringBuilder();
     builder.append("from Position");
     return getHibernateTemplate().find(builder.toString());
    }

    public List<Position> findPosByName(String name) {
       Position pos = null;
       StringBuilder builder = new StringBuilder();
       builder.append("from Position pos");
        if (StringUtils.hasText(name)) {
            builder.append(" where pos.name like '%" + name + "%'");
        }
        return  getHibernateTemplate().find(builder.toString());
    }

    public int getPosSize() {
        StringBuilder builder = new StringBuilder();
        builder.append("select count(pos.id) from Position pos");
        List list =  getHibernateTemplate().find(builder.toString());
        return ((Long)list.get(0)).intValue();
    }

    public boolean loadPosExist(String posName){
        List list = getHibernateTemplate().find("select count(pos.id) from Position pos where pos.name = ?",posName);
        return ((Long)list.get(0)).intValue() > 0 ? true : false;
    }

}
