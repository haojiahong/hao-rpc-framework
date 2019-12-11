package com.hjh.hao.rpc.transport;

import com.hjh.hao.rpc.transport.command.Command;

import java.util.concurrent.CompletableFuture;

/**
 * @author haojiahong created on 2019/12/10
 */
public class ResponseFuture {
    private final int requestId;
    private final CompletableFuture<Command> future;
    private final long timestamp;

    public ResponseFuture(int requestId, CompletableFuture<Command> future) {
        this.requestId = requestId;
        this.future = future;
        timestamp = System.nanoTime();
    }

    public int getRequestId() {
        return requestId;
    }

    public CompletableFuture<Command> getFuture() {
        return future;
    }

    long getTimestamp() {
        return timestamp;
    }
}
