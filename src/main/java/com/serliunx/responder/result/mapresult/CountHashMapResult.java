package com.serliunx.responder.result.mapresult;

import com.serliunx.responder.api.Countable;
import com.serliunx.responder.code.HttpStatusCode;

public class CountHashMapResult extends HashMapResult implements Countable<CountHashMapResult> {
    private int count;

    public CountHashMapResult(HttpStatusCode httpStatusCode, int count) {
        super(httpStatusCode);
        putKeyAndValue("count", 0);
    }

    public CountHashMapResult(int count) {
        this.count = count;
        putKeyAndValue("count", 0);
    }

    public CountHashMapResult() {
        putKeyAndValue("count", 0);
    }

    @Override
    public boolean isCountable() {
        return count != 0;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public CountHashMapResult setCount(int count) {
        putKeyAndValue("count", count);
        this.count = count;
        return this;
    }

    @Override
    public CountHashMapResult putKeyAndValue(String key, Object data) {
        this.count++;
        super.put("count", count);
        super.putKeyAndValue(key, data);
        return this;
    }
}
