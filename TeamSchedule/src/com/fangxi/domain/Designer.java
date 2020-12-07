package com.fangxi.domain;

/**
 * @Author fangxi
 * @Description:
 * @Date 2020-12-06 20:43
 */
public class Designer extends Programmer{
    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }
    public String  getDetails(){
        return super.getDetails()+"\t\t"+this.bonus;
    }
    @Override
    public String toString() {
        return "Designer{" +
                "bonus=" + bonus +
                '}';
    }
}
