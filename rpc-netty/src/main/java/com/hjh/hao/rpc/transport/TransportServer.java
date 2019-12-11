package com.hjh.hao.rpc.transport;

/**
 * @author haojiahong created on 2019/12/10
 */
public interface TransportServer {
    void start(RequestHandlerRegistry requestHandlerRegistry, int port) throws Exception;

    void stop();
}
