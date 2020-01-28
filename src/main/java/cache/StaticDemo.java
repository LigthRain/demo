package cache;

public class StaticDemo {

    public static void main(String[] args) {
        new Runnable() {
            @Override
            public void run() {
                fun("a:");
            }
        }.run();
        new Runnable() {
            @Override
            public void run() {
                fun("b:");
            }
        }.run();
    }

    private synchronized static void fun(String a) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a + Thread.currentThread());
    }

}
