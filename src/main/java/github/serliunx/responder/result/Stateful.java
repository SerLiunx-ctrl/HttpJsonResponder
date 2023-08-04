package github.serliunx.responder.result;

import github.serliunx.responder.code.HttpStatusCode;

/**
 * 定义了返回结果有且只有一种状态
 */
public interface Stateful {
    void setStatus(HttpStatusCode status);

    HttpStatusCode getStatus();
}
