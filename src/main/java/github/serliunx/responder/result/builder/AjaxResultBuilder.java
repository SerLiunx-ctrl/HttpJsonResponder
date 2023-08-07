package github.serliunx.responder.result.builder;

import github.serliunx.responder.Responsive;
import github.serliunx.responder.code.HttpStatusCode;
import github.serliunx.responder.result.DataHolder;
import github.serliunx.responder.result.ajaxresult.CountResult;
import github.serliunx.responder.result.ajaxresult.DefaultAjaxResult;

import java.util.Objects;

public class AjaxResultBuilder implements Builder<DefaultAjaxResult, CountResult>, Responsive, DataHolder<AjaxResultBuilder> {

    private final DefaultAjaxResult defaultAjaxResult;

    public AjaxResultBuilder(HttpStatusCode httpStatusCode) {
        this.defaultAjaxResult = new DefaultAjaxResult(httpStatusCode);
    }

    public AjaxResultBuilder(HttpStatusCode httpStatusCode, Object data) {
        this.defaultAjaxResult = new DefaultAjaxResult(httpStatusCode);
        this.defaultAjaxResult.setData(data);
    }

    public AjaxResultBuilder() {
        this.defaultAjaxResult = new DefaultAjaxResult(HttpStatusCode.SUCCESS);
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
    public CountResult covertToCountable() {
        HttpStatusCode status = this.defaultAjaxResult.getStatus();
        if(status == null) status = HttpStatusCode.SUCCESS;
        CountResult countResult = new CountResult(this.defaultAjaxResult.getData(), status, 0);
        countResult.setData(this.defaultAjaxResult.getData());
        return countResult;
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
