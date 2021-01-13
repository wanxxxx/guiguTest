package annotation;

import java.io.Serializable;

/**
 * @author f
 * @version 1.0
 * @Date 2020/12/14
 * @Description
 */
@MyAnnotation(value = "hello")
@MyAnnotation(value = "hello")
public class Person implements Serializable {
    public static final long serialVersionUID = 4435345345345432L;
    String name;
    Integer age;

    public Person(String name, Integer age) {
        this.name = name;
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
