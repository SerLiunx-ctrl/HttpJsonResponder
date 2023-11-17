package com.serliunx.responder.result.ajaxresult;

import com.serliunx.responder.code.HttpStatusCode;
import com.serliunx.responder.api.Countable;

import java.util.Collection;

public class CountResult extends DefaultAjaxResult implements Countable<CountResult> {

    private int count;

    public CountResult(Object data, String msg, int code, int count) {
        super(data, msg, code);
        this.count = count;
    }

    public CountResult(Object data, HttpStatusCode httpStatusCode, int count){
        this(data, httpStatusCode.message(), httpStatusCode.code(), count);
    }

    @Override
    public boolean isCountable() {
        return this.count != 0;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public CountResult setCount(int count) {
        this.count = count;
        return this;
    }

    @Override
    public String toString() {
        return "CountResult{" +
                "count=" + count +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }

    /**
     * 快速生成集合结果(成功)
     * @param t 集合实例
     * @return 集合结果
     * @param <T> 集合类
     */
    public static <T extends Collection<?>> CountResult success(T t){
        return new CountResult(t, HttpStatusCode.SUCCESS, t.size());
    }

    /**
     * 快速生成可统计结果(结果)
     * @param o 实例
     * @param count 数量
     * @return 可统计的结果
     */
    public static CountResult success(Object o, int count){
        return new CountResult(o, HttpStatusCode.SUCCESS, count);
    }
}
