package generic;

/**
 * @author f
 * @version 1.0
 * @Date 2020/12/17
 * @Description
 * 定义一个 Employee 类，
 * 该类包含：private 成员变量 name,age,birthday，其中 birthday 为 MyDate 类的
 * 对象；
 * 并为每一个属性定义 getter, setter 方法；
 * 并重写 toString 方法输出 name, age, birthday
 */
public class Employee {
    private String name;
    private Integer age;
    private MyDate birthday;
}
