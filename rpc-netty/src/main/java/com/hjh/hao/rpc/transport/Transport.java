package com.hjh.hao.rpc.transport;

import com.hjh.hao.rpc.transport.command.Command;

import java.util.concurrent.CompletableFuture;

/**
 * @author haojiahong created on 2019/12/10
 */
public interface Transport {
    /**
     * 发送请求命令
     *
     * @param request 请求命令
     * @return 返回值是一个Future，Future
     */
    CompletableFuture<Command> send(Command request);

}
