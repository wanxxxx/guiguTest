package Thread;

public class threadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("Thread1");
        myThread.setPriority(10);
        myThread.start();
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(1);

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
//            if (i % 20 == 11) {
//               /* try {
//                    myThread.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }*/
//            }
        }
    }
}
