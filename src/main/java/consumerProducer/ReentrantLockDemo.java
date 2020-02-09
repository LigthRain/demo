package consumerProducer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition notFull = lock.newCondition();

    private static Condition notEmpty = lock.newCondition();

    private static volatile int count = 0;

    public static void main(String[] args) {

        //生产者
        new Thread(() -> {
            lock.lock();
            try {
                Thread.sleep(3000);
                if (count == 10) {
                    notFull.wait();
                }
                count++;
                notEmpty.notify();
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                lock.unlock();
            }
        }).start();

        //消费者
        new Thread(() -> {
            lock.lock();
            try {
                Thread.sleep(3000);
                if (count == 0) {
                    notEmpty.wait();
                }
                count--;
                notFull.notify();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }).start();
    }

}
