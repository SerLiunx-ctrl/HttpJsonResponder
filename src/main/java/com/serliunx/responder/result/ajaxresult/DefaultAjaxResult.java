package com.serliunx.responder.result.ajaxresult;

import com.serliunx.responder.annotation.FieldIgnore;
import com.serliunx.responder.api.result.MapResult;
import com.serliunx.responder.code.HttpStatusCode;
import com.serliunx.responder.exception.DuplicateStatusException;
import com.serliunx.responder.result.builder.HashMapResultBuilder;
import com.serliunx.responder.util.ReflectUtils;
import com.serliunx.responder.api.result.AjaxResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.util.List;

public class DefaultAjaxResult implements AjaxResult {

    protected Object data;
    protected String msg;
    protected int code;

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
        if (status != null){
            checkStatus();
            this.code = status.code();
            this.msg = status.message();
        }else {
            this.code = -1;
            this.msg = null;
        }
    }

    @Override
    @Nullable
    public HttpStatusCode getStatus() {
        return HttpStatusCode.find(this.code);
    }

    @Override
    public MapResult convert() {
        Class<?> clazz = data.getClass();
        List<Field> fields = ReflectUtils.getFieldsWithoutAnnotation(clazz, FieldIgnore.class);
        HashMapResultBuilder builder = MapResult.builder(getStatus());
        fields.forEach(field -> {
            try {
                if(data == null){
                    builder.put(field.getName(), null);
                }else{
                    builder.put(field.getName(), field.get(data));
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
        return builder.build();
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
