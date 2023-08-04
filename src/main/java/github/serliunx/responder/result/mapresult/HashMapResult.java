package github.serliunx.responder.result.mapresult;

import github.serliunx.responder.Responsive;
import github.serliunx.responder.code.HttpStatusCode;

import java.util.HashMap;

public class HashMapResult extends HashMap<String, Object> implements MapResult {

    private HttpStatusCode httpStatusCode;

    public HashMapResult(HttpStatusCode httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public HashMapResult() {
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
        this.httpStatusCode = status;
        super.put("code", status.code());
        super.put("msg", status.message());
    }

    @Override
    public HttpStatusCode getStatus() {
        return this.httpStatusCode;
    }
}
