package com.changhong.user.domain;

import com.changhong.common.domain.EntityBase;


public class Position extends EntityBase{

    private String name;  //名称
    private String des;   //描述

    public Position() {
    }

    public Position(String name) {
        this.name = name;
    }
    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
