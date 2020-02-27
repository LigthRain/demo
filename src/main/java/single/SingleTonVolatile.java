package single;

public class SingleTonVolatile {

    //单例对象必须是static或者类维度的-枚举
    //如果不是则是对象维度的，那不可能是单例
    private static volatile SingleTonVolatile singleTonVolatile;

    //必须是私有的
    private SingleTonVolatile(){

    }

    public static SingleTonVolatile getInstance() {
        //外面的check 是防止在初始化以后 每次获取instance还要上锁
        if (singleTonVolatile == null) {
            synchronized (SingleTonVolatile.class) {
                //里面的check 是防止在初始化那个时刻 有很多线程加入了monitor entry list 当第一个线程释放锁后 其他block的线程再进行一遍new 破坏单例
                if (singleTonVolatile == null) {
                    singleTonVolatile = new SingleTonVolatile();
                }
            }
        }
        return singleTonVolatile;
    }

}
