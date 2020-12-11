package Thread;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * @Author fangxi
 * @Description:
 * @Date 2020-12-09 16:07
 */
class Window2 implements Runnable {
    private int ticket = 100;
    private boolean flag = true;
    private ReentrantLock lock = new ReentrantLock();

    public void run() {
        while (ticket > 0) {

            buyTicket();
        }

    }

    public void buyTicket() {
        lock.lock();
        try {
            if (ticket > 0) {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":成功购买。当前还剩" + ticket + "张票");
                ticket--;
            } else {
                System.out.println(Thread.currentThread().getName() + ":票已卖完");
                flag = false;
            }
        } finally {
            lock.unlock();
        }
    }
}

public class Lock {
    public static void main(String[] args) {
        Window2 w = new Window2();
        Thread window1 = new Thread(w, "窗口1");
        Thread window2 = new Thread(w, "窗口2");
        Thread window3 = new Thread(w, "窗口3");
        window1.start();
        window2.start();
        window3.start();
    }

}
