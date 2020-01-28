package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author wushuangxiaoyu
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String getString() default "asd";

}
