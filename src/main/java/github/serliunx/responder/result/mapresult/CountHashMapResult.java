package github.serliunx.responder.result.mapresult;

import github.serliunx.responder.code.HttpStatusCode;
import github.serliunx.responder.result.Countable;

public class CountHashMapResult extends HashMapResult implements Countable {
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
    public void setCount(int count) {
        putKeyAndValue("count", count);
        this.count = count;
    }

    @Override
    public CountHashMapResult putKeyAndValue(String key, Object data) {
        this.count++;
        super.put("count", count);
        super.putKeyAndValue(key, data);
        return this;
    }
}