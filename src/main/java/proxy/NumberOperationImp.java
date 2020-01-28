package proxy;

/**
 * @author： wushuangxiaoyu
 * @date： 2019/6/22 下午3:13
 */
public class NumberOperationImp implements NumberOperationInterface {
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int addThree(int a, int b, int c) {
        return a+b+c;
    }
}
