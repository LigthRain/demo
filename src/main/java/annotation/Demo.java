package annotation;

/**
 * @author wushuangxiaoyu
 */
@MyAnnotation(getString = "qqq")
public class Demo {

    @MyAnnotation
    public String name;

    @MyAnnotation
    public void myMethod() {}

}
