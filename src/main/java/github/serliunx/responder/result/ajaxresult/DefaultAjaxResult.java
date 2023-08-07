package github.serliunx.responder.result.ajaxresult;

import github.serliunx.responder.code.HttpStatusCode;
import github.serliunx.responder.exception.DuplicateStatusException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DefaultAjaxResult implements AjaxResult {

    private Object data;
    private String msg;
    private int code;

    public DefaultAjaxResult(Object data, @NotNull String msg, int code) {
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    public DefaultAjaxResult(Object data, HttpStatusCode httpStatusCode){
        this(data, httpStatusCode.message(), httpStatusCode.code());
    }

    public DefaultAjaxResult(HttpStatusCode httpStatusCode) {
        this(null, httpStatusCode.message(), httpStatusCode.code());
    }

    @Override
    public DefaultAjaxResult success() {
        setStatus(HttpStatusCode.SUCCESS);
        return this;
    }

    @Override
    public DefaultAjaxResult fail() {
        setStatus(HttpStatusCode.FORBIDDEN);
        return this;
    }

    @Override
    public DefaultAjaxResult notFound() {
        setStatus(HttpStatusCode.NOT_FOUND);
        return this;
    }

    @Override
    public DefaultAjaxResult setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public Object getData() {
        return this.data;
    }

    @Override
    public void setStatus(HttpStatusCode status) {
        checkStatus();
        this.code = status.code();
        this.msg = status.message();
    }

    @Override
    @Nullable
    public HttpStatusCode getStatus() {
        return HttpStatusCode.find(this.code, this.msg);
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return "DefaultAjaxResult{" +
                "data=" + data +
                ", msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }

    /**
     * 内置状态检查
     */
    private void checkStatus(){
        if(this.code >= 0){
            throw new DuplicateStatusException("状态码只允许设置一次!");
        }
    }
}
