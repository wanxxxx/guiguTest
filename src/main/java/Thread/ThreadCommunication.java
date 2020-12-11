package Thread;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * @Author fangxi
 * @Description:
 * @Date 2020-12-09 16:07
 */
class MyThread3 implements Runnable {
    private int numbers = 1;
    private ReentrantLock lock = new ReentrantLock();

    public void run() {
        while (true) {
            synchronized (this) {
                //唤醒其它线程
                notifyAll();

                if (numbers <= 100) {
                    System.out.println(Thread.currentThread().getName() + ": " + numbers);
                    numbers++;
                } else {
                    break;
                }

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        MyThread3 w = new MyThread3();
        Thread t1 = new Thread(w, "线程1");
        Thread t2 = new Thread(w, "线程2");
        Thread t3 = new Thread(w, "线程3");
        t1.start();
        t2.start();
        t3.start();
    }

}
