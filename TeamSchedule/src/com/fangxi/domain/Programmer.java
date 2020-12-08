package com.fangxi.domain;

import com.fangxi.service.Status;

/**
 * @Author fangxi
 * @Description:
 * @Date 2020-12-06 20:43
 */
public class Programmer extends Employee {
    private int memberId = 0;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }


    public String getDetailsOfTeam() {
        return getMemberId() + "/" + super.getDetails() + "\t" + "程序员";
    }

    @Override
    public String toString() {
        return getDetails() + "\t" + "程序员" + "\t" + status + "\t\t\t\t\t" + equipment.toString();
    }
}
