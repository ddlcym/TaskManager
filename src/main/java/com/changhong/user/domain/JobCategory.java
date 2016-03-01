package com.changhong.user.domain;

import com.changhong.common.domain.EntityBase;


public class JobCategory extends EntityBase{

    private String name;

    public JobCategory() {
    }

    public JobCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
