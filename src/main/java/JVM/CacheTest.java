package JVM;

/**
 * @author： wushuangxiaoyu
 * @date： 2019/7/17 下午8:31
 */
public class CacheTest {

    public static void main(String[] args) {
        int[] arr = new int[64 * 1024 * 1024];
//        long timeOne = System.currentTimeMillis();
//        // Loop 1
//        for (int i = 0; i < arr.length; i++) arr[i] *= 3;
//        System.out.println("first loop cost :" + (System.currentTimeMillis() - timeOne));

        // Loop 2
        long timeTwo = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i += 16) arr[i] *= 3;
        System.out.println("second loop cost :" + (System.currentTimeMillis() - timeTwo));
    }

}
