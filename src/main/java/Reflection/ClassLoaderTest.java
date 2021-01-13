package Reflection;

import org.junit.Test;

import java.io.*;
import java.time.temporal.ValueRange;
import java.util.Properties;

/**
 * @author f
 * @version 1.0
 * @Date 2021/1/10
 * @Description
 */
public class
ClassLoaderTest {
    @Test
    public void test1(){
        //System ClassLoader
        ClassLoader classLoader1 = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader1);
        //Extension ClassLoader
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2.toString());
        //Bootstrap ClassLoader获取不到（因为是用C++写的），所以输出null
        ClassLoader classLoader3 = classLoader2.getParent();
        System.out.println(classLoader3);

        //String用的是Bootstrap加载器
        System.out.println(String.class.getClassLoader());
        //Person是自定义，用的是System
        System.out.println(Person.class.getClassLoader());
        System.out.println(ValueRange.class.getClassLoader());
    }
    /**
     * 读取property文件方式一
     * 默认位置在模块下
     * */
    @Test
    public void test2() throws IOException {
        Properties pro=new Properties();
//        pro.load(new FileInputStream("jdbc.properties"));
        pro.load(new FileInputStream("src\\jdbc1.properties"));
        String name = pro.getProperty("name");
        String password = pro.getProperty("password");
        System.out.println(name);
        System.out.println(password);
    }
    /**
     * 读取property文件方式二
     * 默认位置在模块的src文件夹下
     * maven项目位置在resource下
     * */
    @Test
    public void test3() throws IOException {

        Properties pro=new Properties();

        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");

        pro.load(is);

        String name = pro.getProperty("name");
        String password = pro.getProperty("password");
        pro.setProperty("name", "fff");
        System.out.println(name);
        System.out.println(password);
    }
}
