package com.fangxi.domain;

/**
 * @Author fangxi
 * @Description:
 * @Date 2020-12-06 20:43
 */
public class Architect extends Employee {
    private int stock;

    public Architect(int id, String name, int age, double salary, int stock) {
        super(id, name, age, salary);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
