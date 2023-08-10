package github.serliunx.responder.api.result;

import github.serliunx.responder.api.Responsive;
import github.serliunx.responder.api.Countable;

public interface Builder<R extends Responsive, C extends Countable<?>>{

    /**
     * 结果构建器
     * @return 构建器
     */
    R build();

    C covertToCountable();
}
