package com.fangxi.domain;

/**
 * @Author fangxi
 * @Description:
 * @Date 2020-12-06 20:43
 */
public class Designer extends Employee{
    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Designer(int id, String name, int age, double salary, double bonus) {
        super(id, name, age, salary);
        this.bonus = bonus;
    }
}
