package interview.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/3/21 20:54
 */
public class ProducerAndConsumer {
    private final static int MAX_COUNT = 10;
    private List<String> products = new ArrayList<>();

    private ReentrantLock lock = new ReentrantLock();
    private Condition producerCondition = lock.newCondition();
    private Condition consumerCondition = lock.newCondition();


    public void produce(String name) {
        lock.lock();
        try {
            if (products.size() > MAX_COUNT) {
                try {
                    producerCondition.await();
                } catch (InterruptedException e) {
                }
            }
            String product = name;
            products.add(product);
            System.out.println(Thread.currentThread().getName() + "生产者生产了:" + product);
            consumerCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        lock.lock();
        try {
            if (products.size() == 0) {
                try {
                    consumerCondition.await();
                } catch (InterruptedException e) {
                }
            }
            String product = products.remove(products.size() - 1);
            System.out.println(Thread.currentThread().getName() + "消费者消费了:" + product);
            producerCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    static class Producer implements Runnable {
        private ProducerAndConsumer r;

        Producer(ProducerAndConsumer r) {
            this.r = r;
        }

        public void run() {
            for (int i = 0; i < 10; i++)
                r.produce("北京烤鸭" + i);
        }
    }

    static class Consumer implements Runnable {
        private ProducerAndConsumer r;

        Consumer(ProducerAndConsumer r) {
            this.r = r;
        }

        public void run() {
            for (int i = 0; i < 10; i++)
                r.consume();
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumer p =new ProducerAndConsumer();

        Producer pro=new Producer(p);

        Consumer con =new Consumer(p);
        //生产者线程
        Thread t0 = new Thread(pro);
        Thread t1 = new Thread(pro);
        //消费者线程
        Thread t2 = new Thread(con);
        Thread t3 = new Thread(con);
        //启动线程
        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}





