package single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleTest2 {

    private static SingleTest2 singleTest2 = new SingleTest2();

    private SingleTest2() {

    }

    public static SingleTest2 getInstance() {
        return singleTest2;
    }

    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(4);
        executors.submit(() -> {
            SingleTest2 singleTest2 = SingleTest2.getInstance();
            System.out.println(singleTest2);
        });
        executors.submit(() -> {
            SingleTest2 singleTest2 = SingleTest2.getInstance();
            System.out.println(singleTest2);
        });
        executors.submit(() -> {
            SingleTest2 singleTest2 = SingleTest2.getInstance();
            System.out.println(singleTest2);
        });
        executors.submit(() -> {
            SingleTest2 singleTest2 = SingleTest2.getInstance();
            System.out.println(singleTest2);
        });
    }

}
