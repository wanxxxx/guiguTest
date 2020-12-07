package com.fangxi.domain;

import com.fangxi.domain.Equipment;

/**
 * @Author fangxi
 * @Description:
 * @Date 2020-12-06 21:02
 */
public class PC implements Equipment {
    private String model;
    private String display;

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model + "(" + display + ")";

    }
}
