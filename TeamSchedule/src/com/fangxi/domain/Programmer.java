package com.fangxi.domain;

import com.fangxi.service.Status;

/**
 * @Author fangxi
 * @Description:
 * @Date 2020-12-06 20:43
 */
public class Programmer extends Employee {
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer(int id, String name, int age, double salary, int memberId, Equipment equipment) {
        super(id, name, age, salary);
        this.memberId = memberId;
        this.equipment = equipment;
    }
}
