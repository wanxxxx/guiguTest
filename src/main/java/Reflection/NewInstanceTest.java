package Reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;


/**
 * @author f
 * @version 1.0
 * @Date 2021/1/11
 * @Description
 */
public class NewInstanceTest {
    @Test
    public void test1() throws Exception {
        Class cls =Class.forName("Reflection.Person");
        //创建运行时类对象，实际还是取得类的结构，然后获取空参构造器，创建对象
        /*条件：
        需要有空参构造器
        构造器权限得够
        * */
        Constructor cons = cls.getDeclaredConstructor(String.class);
        cons.setAccessible(true);
        Object obj = cons.newInstance("Tom");
        Person p = (Person) obj;
        System.out.println(p.toString());
    }
}
