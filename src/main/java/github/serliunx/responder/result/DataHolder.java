package github.serliunx.responder.result;

import github.serliunx.responder.result.ajaxresult.AjaxResult;

public interface DataHolder<T> {
    T setData(Object data);
    Object getData();
}
