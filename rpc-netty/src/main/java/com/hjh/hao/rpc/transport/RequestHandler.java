package com.hjh.hao.rpc.transport;

import com.hjh.hao.rpc.transport.command.Command;

/**
 * @author haojiahong created on 2019/12/10
 */
public interface RequestHandler {
    /**
     * 处理请求
     *
     * @param requestCommand 请求命令
     * @return 响应命令
     */
    Command handle(Command requestCommand);

    /**
     * 支持的请求类型
     */
    int type();

}
