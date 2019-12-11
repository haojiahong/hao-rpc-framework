package com.hjh.hao.rpc.rpc.server;

import com.hjh.hao.rpc.rpc.service.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author haojiahong created on 2019/12/9
 */
public class HelloServiceImpl implements HelloService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String hello(String name) {
        LOGGER.info("HelloServiceImpl收到: {}.", name);
        String ret = "Hello, " + name;
        LOGGER.info("HelloServiceImpl返回: {}.", ret);
        return ret;
    }
}
