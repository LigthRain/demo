package SecurityManager;

/**
 * @author： wushuangxiaoyu
 * @date： 2019/6/23 下午5:52
 */
public class main {

    public static void main(String[] args) {
//        main m = new main();
//        System.setSecurityManager(m.new SecurityManagerImpl());
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            System.out.println("非空");
            return;
        }
        System.out.println("空");
    }

//    class SecurityManagerImpl extends SecurityManager {
//
//    }

}
