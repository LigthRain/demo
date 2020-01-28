package proxy;

import java.lang.reflect.Proxy;

/**
 * @author： wushuangxiaoyu
 * @date： 2019/6/24 下午11:14
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("$Proxy0.class全名: "+ Proxy.getProxyClass(NumberOperationInterface.class.getClassLoader(), NumberOperationInterface.class));
    }

}
