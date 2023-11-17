package com.serliunx.responder.api.result;

import com.serliunx.responder.api.Countable;
import com.serliunx.responder.api.Responsive;

public interface Builder<R extends Responsive, C extends Countable<?>>{

    /**
     * 结果构建器
     * @return 构建器
     */
    R build();

    C covertToCountable();
}
