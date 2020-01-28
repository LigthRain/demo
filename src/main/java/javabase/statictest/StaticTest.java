package javabase.statictest;

public class StaticTest {

    static {
        System.out.println("静态块");
    }

    {
        System.out.println("构造块");
    }

    public static void main(String[] args) {
        System.out.println("main");
    }

}
