package com.hjh.hao.rpc.serialize;

/**
 * @author haojiahong created on 2019/12/9
 */
public class SerializeException extends RuntimeException {
    public SerializeException(String msg) {
        super(msg);
    }

    public SerializeException(Throwable throwable) {
        super(throwable);
    }
}
