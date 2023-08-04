package github.serliunx.responder.result.builder;

import github.serliunx.responder.Responsive;

public interface Builder<T extends Responsive>{

    /**
     * 结果构建器
     * @return 构建器
     */
    T build();
}
