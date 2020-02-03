package synchronizeQueue;

import java.util.concurrent.SynchronousQueue;

public class BlockTestDemo {

    public static void main(String[] args) throws InterruptedException {
        final SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();

        Thread putThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put thread1 start");
                try {
                    queue.put(1);
                } catch (InterruptedException e) {
                }
                System.out.println("put thread1 end");
            }
        });
        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put thread2 start");
                try {
                    queue.put(2);
                } catch (InterruptedException e) {
                }
                System.out.println("put thread2 end");
            }
        });

        Thread takeThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("take thread1 start");
                try {
                    System.out.println("take1 from putThread: " + queue.take());
                } catch (InterruptedException e) {
                }
                System.out.println("take thread1 end");
            }
        });
        Thread takeThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("take thread2 start");
                try {
                    System.out.println("take2 from putThread: " + queue.take());
                } catch (InterruptedException e) {
                }
                System.out.println("take thread2 end");
            }
        });

        putThread1.start();
        putThread.start();
        Thread.sleep(1000);
        takeThread1.start();
//        takeThread2.start();
    }

}
