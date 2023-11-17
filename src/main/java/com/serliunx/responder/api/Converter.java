package com.serliunx.responder.api;

/**
 * 转换器, 目前用于MapResult和AjaxResult之间转换
 * @author SerLiunx
 * @since 1.3
 */
@FunctionalInterface
public interface Converter<T> {
    T convert();
}
