package github.serliunx.responder.exception;

import github.serliunx.responder.result.builder.Builder;

/**
 * 状态重复异常
 * <p>
 * 一个结果中只允许一种主要状态（成功或失败）
 *
 * @see Builder
 */
public class DuplicateStatusException extends RuntimeException{

    public DuplicateStatusException() {
    }

    public DuplicateStatusException(String message) {
        super(message);
    }

    public DuplicateStatusException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateStatusException(Throwable cause) {
        super(cause);
    }

    public DuplicateStatusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
