package JVM;

/**
 * @author： wushuangxiaoyu
 * @date： 2019/6/29 下午3:01
 */
public class ThrowException {


    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
