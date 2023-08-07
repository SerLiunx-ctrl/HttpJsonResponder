package github.serliunx.responder.result;

public interface Countable<T> {

    boolean isCountable();

    int getCount();

    T setCount(int count);
}
