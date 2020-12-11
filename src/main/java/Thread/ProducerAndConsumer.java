package Thread;

import static java.lang.Thread.sleep;

/**
 * @Author fangxi
 * @Description:生产中消费者问题
 * @Date 2020-12-11 16:59
 */
class Producer implements Runnable {
    Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run() {
        while (true) {
            try {
                sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduct();

        }
    }
}

class Consumer implements Runnable {
    Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run() {
        while (true) {
            try {
                sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.getProduct();

        }
    }
}

class Clerk {
    private int product = 0;
    public static final int MAX = 20;

    public synchronized void addProduct() {
        if (product < MAX) {
            product++;
            System.out.println("生产者给了店员一个产品，当前商品数：" + product);
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void getProduct() {
        if (product > 0) {
            product--;
            System.out.println("消费者拿走了 一个产品，当前商品数：" + product);
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerAndConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Thread productor = new Thread(new Producer(clerk), "生产者");
        Thread consumer = new Thread(new Consumer(clerk), "消费者");
        productor.start();
        consumer.start();
    }
}
