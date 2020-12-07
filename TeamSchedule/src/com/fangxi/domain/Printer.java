package com.fangxi.domain;

import com.fangxi.domain.Equipment;

/**
 * @Author fangxi
 * @Description:
 * @Date 2020-12-06 21:03
 */
public class Printer implements Equipment {
    private String name;
    private String type;

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return name+"("+type+")";
    }

}
