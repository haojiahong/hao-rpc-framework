package com.hjh.hao.rpc.client;

import com.hjh.hao.rpc.transport.Transport;

/**
 * @author haojiahong created on 2019/12/10
 */
public interface StubFactory {
    <T> T createStub(Transport transport, Class<T> serviceClass);
}
