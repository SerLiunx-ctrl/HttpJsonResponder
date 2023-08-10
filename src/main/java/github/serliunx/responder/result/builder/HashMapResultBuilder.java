package github.serliunx.responder.result.builder;

import github.serliunx.responder.api.Responsive;
import github.serliunx.responder.api.result.Builder;
import github.serliunx.responder.code.HttpStatusCode;
import github.serliunx.responder.result.mapresult.CountHashMapResult;
import github.serliunx.responder.result.mapresult.HashMapResult;

import java.util.Set;

public class HashMapResultBuilder implements Builder<HashMapResult, CountHashMapResult>, Responsive{
    private final HashMapResult hashMapResult;

    public HashMapResultBuilder(HttpStatusCode httpStatusCode) {
        hashMapResult = new HashMapResult(httpStatusCode);
    }

    public HashMapResultBuilder(){
        hashMapResult = new HashMapResult();
    }

    public HashMapResultBuilder(HashMapResult hashMapResult) {
        this.hashMapResult = hashMapResult;
        this.hashMapResult.setStatus(null);
    }

    public HashMapResultBuilder put(String key, Object value){
        hashMapResult.put(key, value);
        return this;
    }

    public HashMapResult build(){
        return this.hashMapResult;
    }

    @Override
    public CountHashMapResult covertToCountable() {
        CountHashMapResult countHashMapResult = new CountHashMapResult();
        Set<String> strings = this.hashMapResult.keySet();
        int count = 0;
        for (String string : strings) {
            countHashMapResult.put(string, this.hashMapResult.get(string));
            if(!string.equals("msg") && !string.equals("code")){
                count++;
            }
        }
        countHashMapResult.setCount(count);
        return countHashMapResult;
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
