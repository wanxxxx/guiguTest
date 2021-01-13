package generic;

/**
 * @author f
 * @version 1.0
 * @Date 2020/12/17
 * @Description 定义一个 Employee 类，
 * 该类包含：private 成员变量 name,age,birthday，其中 birthday 为 MyDate 类的
 * 对象；
 * 并为每一个属性定义 getter, setter 方法；
 * 并重写 toString 方法输出 name, age, birthday
 */
public class Employee<T> implements Comparable<Employee> {
    private String name;
    private Integer age;
    private MyDate birthday;
    private T nono;

    public Employee() {
    }

    public Employee(String name, Integer age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public Employee(String name, Integer age, MyDate birthday, T nono) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.nono = nono;
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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "员工信息：" +
                "姓名：'" + name + '\'' +
                ", 年龄：" + age +
                ", 生日：" + birthday +
                '}';
    }


    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }
}
