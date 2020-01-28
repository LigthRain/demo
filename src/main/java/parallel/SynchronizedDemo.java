package parallel;

/**
 * @author： wushuangxiaoyu
 * @date： 2019/7/20 下午9:06
 */
public class SynchronizedDemo {

    public static void method() {
                 synchronized (SynchronizedDemo.class) {
                         System.out.println("Method 1 start");
                    }
             }

    public static void main(String[] args) {
        method();
    }

}
