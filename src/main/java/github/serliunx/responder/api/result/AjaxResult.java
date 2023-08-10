package github.serliunx.responder.api.result;

import github.serliunx.responder.api.Responsive;
import github.serliunx.responder.code.HttpStatusCode;
import github.serliunx.responder.api.DataHolder;
import github.serliunx.responder.api.Stateful;
import github.serliunx.responder.result.ajaxresult.CountResult;
import github.serliunx.responder.result.ajaxresult.DefaultAjaxResult;
import github.serliunx.responder.result.builder.AjaxResultBuilder;

/**
 * AjaxResult 顶层接口
 *
 * @see DefaultAjaxResult
 * @see CountResult
 */
public interface AjaxResult extends Responsive, Stateful, DataHolder<AjaxResult> {

    /**
     * 获取一个结果构建器
     * @see DefaultAjaxResult
     * @return 构建器
     */
    static AjaxResultBuilder builder(){
        return new AjaxResultBuilder(HttpStatusCode.SUCCESS);
    }

    /**
     * 根据状态码获取结果构建器
     *
     * @param httpStatusCode 状态码
     *
     * @see DefaultAjaxResult
     * @return 构建器
     */
    static AjaxResultBuilder builder(HttpStatusCode httpStatusCode){
        return new AjaxResultBuilder(httpStatusCode);
    }

    /**
     * 根据状态码及数据本身获取结果构建器
     * @param httpStatusCode 状态码
     * @param data 数据本身
     *
     * @see DefaultAjaxResult
     * @return 构建器
     */
    static AjaxResultBuilder builder(HttpStatusCode httpStatusCode, Object data){
        return new AjaxResultBuilder(httpStatusCode, data);
    }
}
