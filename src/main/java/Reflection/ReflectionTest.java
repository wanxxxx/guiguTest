package Reflection;

import org.junit.Test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author f
 * @version 1.0
 * @Date 2020/12/22
 * @Description
 */
public class ReflectionTest {
    @Test
    //调用非私有成员
    public void test1() throws Exception {
        //调用构造器
        Class cls = Person.class;
        Constructor cons = cls.getConstructor(String.class, Integer.class);
        Object obj = cons.newInstance("Tom", 23);
        Person p = (Person) obj;
        System.out.println(p.toString());
        //调用属性，不能是私有
        Field age = cls.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p.toString());
        //调用方法
        Method show = cls.getDeclaredMethod("show");
        show.invoke(p);

    }
    @Test
    //调用私有成员
    public void test2() throws Exception {
        Class cls = Person.class;

        //调用私有构造器
        Constructor cons = cls.getDeclaredConstructor(String.class);
        cons.setAccessible(true);
        Object obj = cons.newInstance("Tom");
        Person p = (Person) obj;
        System.out.println(p);
        //调用私有属性
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p, "Bob");
        System.out.println(p.toString());
        //调用私有方法
        Method show2 = cls.getDeclaredMethod("show");
        show2.setAccessible(true);
        show2.invoke(p);
    }
}
