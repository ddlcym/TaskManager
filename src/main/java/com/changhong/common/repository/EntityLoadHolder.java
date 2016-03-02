package com.changhong.common.repository;

/**
 * Created by IntelliJ IDEA.
 * User: di
 * Date: 16-3-1
 * Time: 下午4:53
 * To change this template use File | Settings | File Templates.
 */
public class EntityLoadHolder {

    private static EntityObjectDao  ObjectDao;

    public static EntityObjectDao getObjectDao() {
        return ObjectDao;
    }

    public void setObjectDao(EntityObjectDao objectDao) {
        ObjectDao = objectDao;
    }
}
