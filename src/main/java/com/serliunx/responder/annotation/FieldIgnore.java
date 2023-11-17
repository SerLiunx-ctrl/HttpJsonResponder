package com.serliunx.responder.annotation;

import com.serliunx.responder.api.Converter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用{@link Converter}接口时,可以使用该注解忽略特定属性
 * @see Converter
 * @author SerLiunx
 * @since 1.3
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldIgnore {

    /**
     * 分组
     * <li> 有些时候可能不需要忽略此属性、使用分组达到此效果
     */
    Class<?>[] value() default {};
}
