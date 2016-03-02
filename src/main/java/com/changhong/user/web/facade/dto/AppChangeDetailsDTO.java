package com.changhong.user.web.facade.dto;

/**
 * User: Jack Wang
 * Date: 15-9-1
 * Time: 下午2:47
 */
public class AppChangeDetailsDTO {

    private String field;

    private String description;

    public AppChangeDetailsDTO(String field, String description) {
        this.field = field;
        this.description = description;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
