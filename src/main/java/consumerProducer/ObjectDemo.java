package consumerProducer;

public class ObjectDemo {

    private Object lock = new Object();

    private volatile int count = 0;

    public static void main(String[] args) {
        ObjectDemo objectDemo = new ObjectDemo();
        new Thread(objectDemo.new Producer()).start();
        new Thread(objectDemo.new Producer()).start();
        new Thread(objectDemo.new Producer()).start();
        new Thread(objectDemo.new Consumer()).start();
        new Thread(objectDemo.new Consumer()).start();
        new Thread(objectDemo.new Consumer()).start();
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":Consumer start,目前有" + count + "个");
                synchronized (lock) {
                    if (count == 0) {
                        System.out.println("目前没有了");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    lock.notifyAll();
                    System.out.println(Thread.currentThread().getName() + ":Consumer notifyAll，目前有" + count + "个");
                }
            }
        }
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":Produce start,目前有" + count + "个");
                synchronized (lock) {
                    if (count == 10) {
                        System.out.println("目前满了");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    lock.notifyAll();
                    System.out.println(Thread.currentThread().getName() + ":Producer notifyAll，目前有" + count + "个");
                }
            }
        }
    }
}
