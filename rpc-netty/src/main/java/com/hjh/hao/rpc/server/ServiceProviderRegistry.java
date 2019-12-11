package com.hjh.hao.rpc.server;

/**
 * @author haojiahong created on 2019/12/10
 */
public interface ServiceProviderRegistry {
    <T> void addServiceProvider(Class<? extends T> serviceClass, T serviceProvider);
}
