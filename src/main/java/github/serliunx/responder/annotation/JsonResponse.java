package github.serliunx.responder.annotation;

import github.serliunx.responder.code.HttpStatusCode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface JsonResponse {

    HttpStatusCode code() default HttpStatusCode.SUCCESS;
}
