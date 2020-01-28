package annotation;

import java.lang.reflect.Field;

/**
 * @author wushuangxiaoyu
 */
public class TestDemo {

    public static void main(String[] args) {
        Class<Demo> clazz = Demo.class;
        MyAnnotation myAnnotation = clazz.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation.getString());

        try {
            Field name = clazz.getField("name");
            MyAnnotation annotation = name.getAnnotation(MyAnnotation.class);
            System.out.println(annotation.getString());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
