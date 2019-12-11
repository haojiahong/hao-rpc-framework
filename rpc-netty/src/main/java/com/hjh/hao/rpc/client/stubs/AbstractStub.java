package com.hjh.hao.rpc.client.stubs;

import com.hjh.hao.rpc.client.RequestIdSupport;
import com.hjh.hao.rpc.client.ServiceStub;
import com.hjh.hao.rpc.client.ServiceTypes;
import com.hjh.hao.rpc.serialize.SerializeSupport;
import com.hjh.hao.rpc.transport.Transport;
import com.hjh.hao.rpc.transport.command.Code;
import com.hjh.hao.rpc.transport.command.Command;
import com.hjh.hao.rpc.transport.command.Header;
import com.hjh.hao.rpc.transport.command.ResponseHeader;

import java.util.concurrent.ExecutionException;

/**
 * @author haojiahong created on 2019/12/10
 */
public class AbstractStub implements ServiceStub {

    protected Transport transport;

    protected byte[] invokeRemote(RpcRequest request) {
        Header header = new Header(ServiceTypes.TYPE_RPC_REQUEST, 1, RequestIdSupport.next());
        byte[] payload = SerializeSupport.serialize(request);
        Command requestCommand = new Command(header, payload);
        try {
            Command responseCommand = transport.send(requestCommand).get();
            ResponseHeader responseHeader = (ResponseHeader) responseCommand.getHeader();
            if (responseHeader.getCode() == Code.SUCCESS.getCode()) {
                return responseCommand.getPayload();
            } else {
                throw new Exception(responseHeader.getError());
            }

        } catch (ExecutionException e) {
            throw new RuntimeException(e.getCause());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setTransport(Transport transport) {
        this.transport = transport;
    }
}
