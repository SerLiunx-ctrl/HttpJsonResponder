package github.serliunx.responder.result.builder;

import github.serliunx.responder.Responsive;
import github.serliunx.responder.result.Countable;

public interface Builder<R extends Responsive, C extends Countable<?>>{

    /**
     * 结果构建器
     * @return 构建器
     */
    R build();

    C covertToCountable();
}
