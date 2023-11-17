package com.serliunx.responder.result.mapresult;

import com.serliunx.responder.api.result.MapResult;
import com.serliunx.responder.code.HttpStatusCode;
import com.serliunx.responder.exception.DuplicateStatusException;

import java.util.HashMap;

public class HashMapResult extends HashMap<String, Object> implements MapResult {

    private HttpStatusCode httpStatusCode;

    public HashMapResult(HttpStatusCode httpStatusCode) {
        setStatus(httpStatusCode);
    }

    public HashMapResult() {
    }

    @Override
    public MapResult putKeyAndValue(String key, Object data) {
        super.put(key, data);
        return this;
    }

    @Override
    public HashMapResult fail() {
        this.setStatus(HttpStatusCode.FORBIDDEN);
        return this;
    }

    @Override
    public HashMapResult success() {
        this.setStatus(HttpStatusCode.SUCCESS);
        return this;
    }

    @Override
    public HashMapResult notFound() {
        this.setStatus(HttpStatusCode.NOT_FOUND);
        return this;
    }

    @Override
    public void setStatus(HttpStatusCode status) {
        checkStatus();
        this.httpStatusCode = status;
        if(status != null){
            this.putKeyAndValue("code", status.code());
            this.putKeyAndValue("msg", status.message());
        }
    }

    @Override
    public HttpStatusCode getStatus() {
        return this.httpStatusCode;
    }

    @Override
    public int getCode() {
        return this.httpStatusCode.code();
    }

    /**
     * 内置状态检查
     */
    protected void checkStatus(){
        if(this.httpStatusCode != null){
            throw new DuplicateStatusException("状态码只允许设置一次!");
        }
    }
}
