package Reflection;


import java.io.Serializable;


public class Person {
    private String name;
    public Integer age;


    public void show() {
        System.out.println("我叫" + getName() + "，" + getAge() + "岁");
    }

    private void show2(String name) {
        System.out.println("私有方法"+name);
    }

    public void Person() {
    }

    private Person(String name) {
        this.name = name;
        this.age = 18;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
