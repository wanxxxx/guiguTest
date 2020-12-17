package annotation;


import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.TYPE_PARAMETER;

/**
 * @author f
 * @version 1.0
 * @Date 2020/12/14
 * @Description
 */
@Target({TYPE,TYPE_PARAMETER})
public @interface MyAnnotations {
    MyAnnotation [] value();
}
