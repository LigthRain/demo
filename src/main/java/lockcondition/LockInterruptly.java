package lockcondition;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptly {

    public static void main(String[] args) {
        LockObject2 lockObject2 = new LockObject2();
        MyThread2 myThread1 = new MyThread2(lockObject2);
        MyThread2 myThread2 = new MyThread2(lockObject2);
        Thread t1 = new Thread(myThread1);
        Thread t2 = new Thread(myThread2);
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        t2.interrupt();
    }

}


class LockObject2 {
    Lock lock = new ReentrantLock();

    public void lockFuntion(){
        try {
            lock.lockInterruptibly();
            System.out.println(Thread.currentThread().getName() + ":获取到了🔐");
            while (true) {

            }
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + "被中断");
        } finally {
            System.out.println(Thread.currentThread().getName() + ":释放了🔐");
        }
    }

}

class MyThread2 implements Runnable {
    LockObject2 lockObject;

    public MyThread2(LockObject2 lockObject) {
        this.lockObject = lockObject;
    }


    @Override
    public void run() {
        lockObject.lockFuntion();
    }
}