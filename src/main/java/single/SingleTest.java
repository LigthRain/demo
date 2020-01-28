package single;

public class SingleTest {

    private static volatile SingleTest singleTest;

    private SingleTest() {}

    public static SingleTest getInstance() {
        if (singleTest == null) {
            synchronized (SingleTest.class) {
                if (singleTest == null) {
                    singleTest = new SingleTest();
                }
            }
        }
        return singleTest;
    }

}
