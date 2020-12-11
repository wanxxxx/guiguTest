package Thread;

import static java.lang.Thread.sleep;

/**
 * @Author fangxi
 * @Description:第二种创建线程的方法
 * @Date 2020-12-09 16:58
 */
class MyThread2 implements Runnable{

    public void run() {
        for (int i = 0; i < 100; i++) {
//            try {
//                sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

}

public class MyThreadTest2 {


    public static void main(String[] args) {
        Thread thread1=new Thread(new MyThread2());
        Thread thread2=new Thread(new MyThread2());
        thread1.start();
        thread2.start();
    }
}
