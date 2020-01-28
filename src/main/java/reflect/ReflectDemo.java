package reflect;

public class ReflectDemo {

    public static void main(String[] args) {
        Class<ReflectedClass> reflectedClazz = ReflectedClass.class;
        try {
            reflectedClazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
