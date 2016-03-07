package com.changhong.user.web.facade.dto;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: lenovo
 * Date: 16-3-3
 * Time: 下午3:38
 * To change this template use File | Settings | File Templates.
 */
public class PositionDTO implements Serializable {

    private String name;
    private String des;

    public PositionDTO() {
    }

    public PositionDTO(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
