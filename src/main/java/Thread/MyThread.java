package Thread;

/**
 * @Author fangxi
 * @Description:
 * @Date 2020-12-09 14:03
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
           /* try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            System.out.println(Thread.currentThread().getName() + ":" + i);

        }
    }

    public MyThread(String name) {
        super(name);
    }
}
