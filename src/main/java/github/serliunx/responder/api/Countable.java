package github.serliunx.responder.api;

public interface Countable<T> {

    boolean isCountable();

    int getCount();

    T setCount(int count);
}
