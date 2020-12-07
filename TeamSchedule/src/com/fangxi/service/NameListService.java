package com.fangxi.service;

import com.fangxi.domain.*;

import static com.fangxi.service.Data.*;

/**
 * @Author fangxi
 * @Description:
 * @Date 2020-12-06 21:17
 */
public class NameListService {
    private Employee[] employees;

    public NameListService() {
    //根据项目提供的Data类构建相应大小的employees数组
        employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < EMPLOYEES.length; i++) {
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment = null;
            double bonus = 0;
            int stock = 0;
            switch (type) {
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    equipment = createNewEq(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case DESIGNER:
                    equipment = createNewEq(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case ARCHITECT:
                    equipment = createNewEq(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
            }
        }

    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int index) {
        return employees[index];
    }

    public Equipment createNewEq(int index) {
        int type = Integer.parseInt(EQUIPMENTS[index][0]);
        String str1 = EQUIPMENTS[index][1];
        String str2 = EQUIPMENTS[index][3];
        switch (type) {
            case PC:
                return new PC(str1, str2);

            case NOTEBOOK:
                return new NoteBook(str1, Double.parseDouble(str2));
            case PRINTER:
                return new Printer(str1, str2);
        }
        return null;
    }
}
