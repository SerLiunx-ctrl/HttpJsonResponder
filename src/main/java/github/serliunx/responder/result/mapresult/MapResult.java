package github.serliunx.responder.result.mapresult;

import github.serliunx.responder.Responsive;
import github.serliunx.responder.code.HttpStatusCode;
import github.serliunx.responder.result.Stateful;
import github.serliunx.responder.result.builder.HashMapResultBuilder;

import java.util.Map;

public interface MapResult extends Map<String, Object>, Responsive, Stateful {

    static HashMapResultBuilder builder(HttpStatusCode httpStatusCode){
        return new HashMapResultBuilder(httpStatusCode);
    }

    static HashMapResultBuilder builder(){
        return new HashMapResultBuilder();
    }
}
