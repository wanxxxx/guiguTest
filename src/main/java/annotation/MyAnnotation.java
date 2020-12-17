package annotation;

import java.lang.annotation.*;
import java.lang.reflect.Type;

import static java.lang.annotation.ElementType.*;

/**
 * @author f
 * @version 1.0
 * @Date 2020/12/14
 * @Description
 */
@Repeatable(MyAnnotations.class)
@Target({TYPE,TYPE_PARAMETER})
public @interface MyAnnotation {
//    String[] value() default "myAnnotation";
    String[] value() default "hello";

}
