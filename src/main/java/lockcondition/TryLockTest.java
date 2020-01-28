package lockcondition;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockTest {

    public static void main(String[] args) {
        LockObject1 lockObject = new LockObject1();
        MyThread1 myThread1 = new MyThread1(lockObject);
        MyThread1 myThread2 = new MyThread1(lockObject);
        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);
        thread1.start();
        thread2.start();
    }

}

class LockObject1 {
    Lock lock = new ReentrantLock();

    public void lockFuntion(){
        if (lock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() + ":获取到了🔐");
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + ":释放了🔐");
            }
        } else {
            System.out.println(Thread.currentThread().getName() + ":没获取到🔐");
        }
    }

}

class MyThread1 implements Runnable {
    LockObject1 lockObject;

    public MyThread1(LockObject1 lockObject) {
        this.lockObject = lockObject;
    }


    @Override
    public void run() {
        lockObject.lockFuntion();
    }
}
