package reflection1_annotation1;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME) // when is the annotation checked
@Target({ TYPE, METHOD }) // where can we add the annotation
public @interface annotation1 {
	String value();
	boolean isRunnable();
}
