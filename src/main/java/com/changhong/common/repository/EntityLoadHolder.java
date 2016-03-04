package com.changhong.common.repository;

import com.changhong.user.repository.UserDao;

/**
 * Created by IntelliJ IDEA.
 * User: di
 * Date: 16-3-1
 * Time: 下午4:53
 * To change this template use File | Settings | File Templates.
 */
public class EntityLoadHolder {

     private static UserDao userDao;

    public static UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
    	EntityLoadHolder.userDao = userDao;
    }
}
