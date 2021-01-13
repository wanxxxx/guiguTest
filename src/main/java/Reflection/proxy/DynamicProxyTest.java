package Reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author f
 * @version 1.0
 * @Date 2021/1/11
 * @Description
 */

interface Human{
    public String getRace();
    public void eat();
}

//被代理类
class Black implements Human{

    @Override
    public String getRace() {
        return "black";
    }

    @Override
    public void eat() {
        System.out.println("黑人吃东西");
    }
}
class Yellow implements Human{

    @Override
    public String getRace() {
        return "yellow";
    }

    @Override
    public void eat() {
        System.out.println("中国人吃东西");
    }
}

/**
 * 被代理类加载到内存，然后动态地去创建一个代理类及其对象
 * 调用代理类的对象的方法，动态地去调用被代理类同名方法
 * */
class ProxyFactory{
    //调用此静态方法，返回一个代理类对象
    public static Object getProxyInstance(Object obj){//obj是被代理类对象
        MyInvocationHandler handler=new MyInvocationHandler();

        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                handler
        );
    }
}
class MyInvocationHandler implements InvocationHandler{
    private Object obj;//用被代理类赋值

    public void setObj(Object obj){
        this.obj=obj;
    }

    /**
     * 当我们通过代理类的对象，调用方法时，就会自动调用Handler里的invoke()
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method为代理类对象调用的方法
        //obj被代理类对象

        //当通过代理类对象调用方法a的时候，就会自动调用invoke()
        return method.invoke(obj,args);
    }
}
public class DynamicProxyTest {
    public static void main(String[] args) {

    }
}
