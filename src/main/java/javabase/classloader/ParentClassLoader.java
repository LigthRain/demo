package javabase.classloader;

public class ParentClassLoader {

    public static void main(String[] args) {
        ClassLoader classLoader = ParentClassLoader.class.getClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader.toString());
            classLoader = classLoader.getParent();
        }
    }

}
