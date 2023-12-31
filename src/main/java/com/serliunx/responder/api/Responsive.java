package com.serliunx.responder.api;

import com.serliunx.responder.result.ajaxresult.DefaultAjaxResult;
import com.serliunx.responder.result.mapresult.HashMapResult;
import com.serliunx.responder.api.result.MapResult;
import com.serliunx.responder.api.result.AjaxResult;

/**
 * <li> 响应顶层接口
 * <li> 用于约束必须实现的方法
 *
 * @see AjaxResult
 * @see MapResult
 *
 * @author SerLiunx
 * @since 1.0
 */
public interface Responsive {

    /**
     * 请求失败
     * @return 响应
     */
    Responsive fail();

    /**
     * <li>成功响应请求
     * <li>默认使用的是200状态码
     *
     * @see HashMapResult
     * @see DefaultAjaxResult
     * @return 响应
     */
    Responsive success();

    Responsive notFound();
}
