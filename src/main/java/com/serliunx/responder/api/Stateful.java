package com.serliunx.responder.api;

import com.serliunx.responder.code.HttpStatusCode;
import com.serliunx.responder.result.ajaxresult.DefaultAjaxResult;
import com.serliunx.responder.result.mapresult.HashMapResult;

/**
 * 定义了返回结果有且只有一种状态
 *
 * <p> 请在实现中检查结果的状态是否已经设置
 *
 * @see DefaultAjaxResult
 * @see HashMapResult
 */
public interface Stateful {

    void setStatus(HttpStatusCode status);

    HttpStatusCode getStatus();

    int getCode();
}
