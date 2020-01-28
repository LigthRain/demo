package lockcondition;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    public static void main(String[] args) {

        LockObject lockObject = new LockObject();
        MyThread myThread1 = new MyThread(lockObject);
        MyThread myThread2 = new MyThread(lockObject);
        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);
        thread1.start();
        thread2.start();

    }
}

class LockObject {
    Lock lock = new ReentrantLock();

    public void lockFuntion(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + ":获取到了🔐");
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + ":释放了🔐");
        }
    }

}

class MyThread implements Runnable {
    LockObject lockObject;

    public MyThread(LockObject lockObject) {
        this.lockObject = lockObject;
    }


    @Override
    public void run() {
        lockObject.lockFuntion();
    }
}
