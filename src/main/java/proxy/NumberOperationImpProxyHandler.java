package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author： wushuangxiaoyu
 * @date： 2019/6/22 下午3:06
 */
public class NumberOperationImpProxyHandler implements InvocationHandler {

    private Object proxied;

    public NumberOperationImpProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    /**
     *
     * @param proxy  委托类
     * @param method  方法
     * @param args  参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.printf("被代理的函数%s\n", method.getName());
        return method.invoke(proxied, args);
    }
}
