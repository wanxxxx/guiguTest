package Reflection.Proxy12306;

import org.junit.Test;

/**
 * @author f
 * @version 1.0
 * @Date 2021/1/11
 * @Description
 * 代理类和被代理类在编译前就确定了
 */
interface subject{
    public void request();
}
class TrainStation implements subject{

    @Override
    public void request() {
        System.out.println("火车站为您购票中...");
    }
}
class Proxy12306 implements subject{
    TrainStation trainStation;

    public Proxy12306(TrainStation trainStation) {
        this.trainStation = trainStation;
    }

    public void preRequest() {
        System.out.println("打开12306网页");
    }

    public void postRequest() {
        System.out.println("12306帮你成功订购火车票");
    }

    @Override
    public void request() {
        preRequest();
        trainStation.request();
        postRequest();
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        TrainStation rel=new TrainStation();
        Proxy12306 Proxy12306 = new Proxy12306(rel);
        Proxy12306.request();
    }
}
