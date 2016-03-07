package com.changhong.user.repository;

import com.changhong.common.repository.EntityObjectDao;
import com.changhong.user.domain.Position;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: di
 * Date: 16-2-26
 * Time: 下午1:47
 * To change this template use File | Settings | File Templates.
 */
public interface JobCategotyDao extends EntityObjectDao {
     /**************************************类别部分****************************************/

    List<Position> loadAllCategory();
    List<Position> findJobByName(String name);
    int getJobCategorySize();
}
