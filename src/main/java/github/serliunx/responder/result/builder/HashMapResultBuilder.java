package github.serliunx.responder.result.builder;

import github.serliunx.responder.Responsive;
import github.serliunx.responder.code.HttpStatusCode;
import github.serliunx.responder.result.mapresult.HashMapResult;

public class HashMapResultBuilder implements Builder<HashMapResult>, Responsive{
    private final HashMapResult hashMapResult;

    public HashMapResultBuilder(HttpStatusCode httpStatusCode) {
        hashMapResult = new HashMapResult(httpStatusCode);
    }

    public HashMapResultBuilder(){
        hashMapResult = new HashMapResult();
    }

    public HashMapResultBuilder put(String key, Object value){
        hashMapResult.put(key, value);
        return this;
    }

    public HashMapResult build(){
        return this.hashMapResult;
    }

    @Override
    public HashMapResultBuilder fail() {
        this.hashMapResult.fail();
        return this;
    }

    @Override
    public HashMapResultBuilder success() {
        this.hashMapResult.success();
        return this;
    }

    @Override
    public HashMapResultBuilder notFound() {
        this.hashMapResult.notFound();
        return this;
    }
}
