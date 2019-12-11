package com.hjh.hao.rpc.client;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author haojiahong created on 2019/12/10
 */
public class RequestIdSupport {
    private final static AtomicInteger nextRequestId = new AtomicInteger(0);

    public static int next() {
        return nextRequestId.getAndIncrement();
    }
}
