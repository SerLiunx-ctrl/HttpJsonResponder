package github.serliunx.responder.api;

public interface DataHolder<T> {
    T setData(Object data);
    Object getData();
}
