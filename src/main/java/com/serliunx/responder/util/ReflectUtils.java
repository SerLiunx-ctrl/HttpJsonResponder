package com.serliunx.responder.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 反射相关工具类
 * @author SerLiunx
 * @since 1.3
 */
public final class ReflectUtils {

    private ReflectUtils(){}

    /**
     * 获取特定类下所有被指定注解标注的属性
     * @param clazz 类
     * @param annotation 注解
     * @return 符合要求的属性
     */
    public static List<Field> getAnnotatedFields(Class<?> clazz, Class<? extends Annotation> annotation){
        Field[] fields = clazz.getDeclaredFields();
        return Arrays.stream(fields)
                .filter(f -> f.getAnnotation(annotation) != null)
                .peek(f -> f.setAccessible(true))
                .collect(Collectors.toList());
    }

    /**
     * 获取特定类下所有未指定注解标注的属性
     * @param clazz 类
     * @param annotation 注解
     * @return 符合要求的属性
     */
    public static List<Field> getFieldsWithoutAnnotation(Class<?> clazz, Class<? extends Annotation> annotation){
        Field[] fields = clazz.getDeclaredFields();
        return Arrays.stream(fields)
                .filter(f -> f.getAnnotation(annotation) == null)
                .peek(f -> f.setAccessible(true))
                .collect(Collectors.toList());
    }
}
