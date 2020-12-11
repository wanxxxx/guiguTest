package Thread;

import javax.swing.plaf.TableHeaderUI;

import static java.lang.Thread.sleep;

/**
 * @Author fangxi
 * @Description:
 * @Date 2020-12-09 16:07
 */
class Window implements Runnable {
    private int ticket = 100;
    private boolean flag = true;
    private Object obj = new Object();

    public void run() {
        synchronized (obj) {
            while (flag) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":成功购买。当前还剩" + ticket + "张票");
                    ticket--;
                } else {
                    System.out.println(Thread.currentThread().getName() + ":票已卖完");
                    flag = false;
                }
            }
        }
    }
}

public class WindowTest {
    public static void main(String[] args) {
        Window w = new Window();
        Thread window1 = new Thread(w, "窗口1");
        Thread window2 = new Thread(w, "窗口2");
        Thread window3 = new Thread(w, "窗口3");
        window1.start();
        window2.start();
        window3.start();
    }

}
