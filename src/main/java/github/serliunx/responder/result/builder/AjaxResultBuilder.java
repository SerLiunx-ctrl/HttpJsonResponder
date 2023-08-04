package github.serliunx.responder.result.builder;

import github.serliunx.responder.Responsive;
import github.serliunx.responder.code.HttpStatusCode;
import github.serliunx.responder.result.DataHolder;
import github.serliunx.responder.result.ajaxresult.AjaxResult;
import github.serliunx.responder.result.ajaxresult.DefaultAjaxResult;

public class AjaxResultBuilder implements Builder<DefaultAjaxResult>, Responsive, DataHolder<AjaxResultBuilder> {

    private final DefaultAjaxResult defaultAjaxResult;

    public AjaxResultBuilder(HttpStatusCode httpStatusCode) {
        this.defaultAjaxResult = new DefaultAjaxResult(httpStatusCode);
    }

    public AjaxResultBuilder(HttpStatusCode httpStatusCode, Object data) {
        this.defaultAjaxResult = new DefaultAjaxResult(httpStatusCode);
        this.defaultAjaxResult.setData(data);
    }

    @Override
    public AjaxResultBuilder setData(Object data) {
        this.defaultAjaxResult.setData(data);
        return this;
    }

    @Override
    public Object getData() {
        return this.defaultAjaxResult.getData();
    }

    @Override
    public DefaultAjaxResult build() {
        return this.defaultAjaxResult;
    }

    @Override
    public AjaxResultBuilder fail() {
        this.defaultAjaxResult.fail();
        return this;
    }

    @Override
    public AjaxResultBuilder success() {
        this.defaultAjaxResult.success();
        return this;
    }

    @Override
    public AjaxResultBuilder notFound() {
        this.defaultAjaxResult.notFound();
        return this;
    }
}
