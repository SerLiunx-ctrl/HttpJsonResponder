package github.serliunx.responder.result.ajaxresult;

import github.serliunx.responder.Responsive;
import github.serliunx.responder.code.HttpStatusCode;
import github.serliunx.responder.result.DataHolder;
import github.serliunx.responder.result.Stateful;
import github.serliunx.responder.result.builder.AjaxResultBuilder;

public interface AjaxResult extends Responsive, Stateful, DataHolder<AjaxResult> {
    static AjaxResultBuilder builder(HttpStatusCode httpStatusCode){
        return new AjaxResultBuilder(httpStatusCode);
    }

    static AjaxResultBuilder builder(HttpStatusCode httpStatusCode, Object data){
        return new AjaxResultBuilder(httpStatusCode, data);
    }
}
