package github.serliunx.responder.result.mapresult;

import github.serliunx.responder.Responsive;
import github.serliunx.responder.code.HttpStatusCode;
import github.serliunx.responder.result.Stateful;
import github.serliunx.responder.result.builder.HashMapResultBuilder;

import java.util.Map;

/**
 * MapResult 顶层接口
 *
 * @see HashMapResult
 */
public interface MapResult extends Map<String, Object>, Responsive, Stateful {

    /**
     * 放入键值对
     * @param key 键
     * @param data 值
     * @return 返回当前结果（链式调用）
     */
    MapResult putKeyAndValue(String key, Object data);

    static HashMapResultBuilder builder(HttpStatusCode httpStatusCode){
        return new HashMapResultBuilder(httpStatusCode);
    }

    static HashMapResultBuilder builder(){
        return new HashMapResultBuilder();
    }
}
