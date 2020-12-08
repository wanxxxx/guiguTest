package com.fangxi.domain;

import com.fangxi.domain.Equipment;

/**
 * @Author fangxi
 * @Description:
 * @Date 2020-12-06 21:02
 */
public class NoteBook implements Equipment {
    private String model;
    private double price;

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return model+"("+price+")";
    }
}
