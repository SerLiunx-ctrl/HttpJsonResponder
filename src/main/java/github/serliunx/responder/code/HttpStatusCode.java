package github.serliunx.responder.code;

/**
 * HTTP请求状态码
 */
public enum HttpStatusCode {
    CONTINUE(100, "服务器已请求的到一部分, 正在等待其余部分."),
    SWITCH(101, "正在准备切换协议."),
    SUCCESS(200, "请求成功!"),
    CREATED(201, "服务器已创建新资源!"),
    ACCEPTED(202, "已接受, 但尚未处理"),
    DATA_UNVERIFIED(203, "返回数据未经验证!"),
    DATA_EMPTY(204, "请求成功, 但没有任何数据!"),
    DATA_EMPTIED(205, "请求成功, 但数据被重置!"),
    DATA_PART(206, "请求成功, 数据并不完整!"),
    MULTIPLE(300, "有多种请求."),
    MOVED_PERMANENT(301, "原地址已永久移动至其它位置, 重定向中."),
    MOVED_TEMPORARY(302, "源地址临时移动到其它位置, 重定向中."),
    TO_OTHERS(303, "该地址无法响应该请求."),
    UNMODIFIED(304, "继上次请求结果并未发生改变."),
    USE_PROXY(305, "请使用代理!"),
    TEMPORARY_REDIRECT(307, "该地址将来也许会弃用, 请使用新的地址发情请求."),
    BAD_REQUEST(400, "请求语法有误, 服务器无法理解!"),
    UNAUTHORIZED(401, "未授权!"),
    OTHERS(402, "保留状态码"),
    FORBIDDEN(403, "禁止访问!"),
    NOT_FOUND(404, "未找到该资源!"),
    METHOD_DISABLED(405, "禁止在此处使用改请求方式!");

    private final int code;
    private final String message;

    HttpStatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static HttpStatusCode find(int code, String message){
        HttpStatusCode httpStatusCode = null;
        for (HttpStatusCode value : HttpStatusCode.values()) {
            if(value.code == code && value.message.equals(message)){
                httpStatusCode = value;
            }
        }
        return httpStatusCode;
    }
}
