package proxy;

import java.lang.reflect.Proxy;

/**
 * @author： wushuangxiaoyu
 * @date： 2019/6/22 下午3:21
 */
public class main {

    public static void main(String[] args) {
        NumberOperationInterface proxied = new NumberOperationImp();
        NumberOperationInterface real = wrap(proxied);
        real.add(1, 2);
        real.addThree(1, 2, 3);
    }

    public static NumberOperationInterface wrap(NumberOperationInterface proxied) {
        return (NumberOperationInterface) Proxy.newProxyInstance(
                NumberOperationInterface.class.getClassLoader(),
                new Class[]{NumberOperationInterface.class},
                new NumberOperationImpProxyHandler(proxied));
    }

}
