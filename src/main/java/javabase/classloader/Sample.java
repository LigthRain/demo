package javabase.classloader;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Sample<T> {

    public int a;
    private T T;

    public T sout() {
//        @SuppressWarnings("unchecked")
//        T result = (T)new Sample<Integer>().a;
        System.out.println("aaa");
        return T;
    }

}
