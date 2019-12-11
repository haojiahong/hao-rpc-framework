package com.hjh.hao.rpc.client;

import com.hjh.hao.rpc.client.stubs.AbstractStub;
import com.hjh.hao.rpc.transport.Transport;
import javassist.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author haojiahong created on 2019/12/11
 */
public class JavassistStubFactory implements StubFactory {

    @Override
    public <T> T createStub(Transport transport, Class<T> serviceClass) {
        String stubSimpleName = serviceClass.getSimpleName() + "Stub";
        String stubFullName = "com.hjh.hao.rpc.client.stubs." + stubSimpleName;

        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass serviceCtClass = pool.get(serviceClass.getName());
            CtClass abstractStubCtClass = pool.get(AbstractStub.class.getName());
            CtClass cc = pool.makeClass(stubFullName);
            cc.setInterfaces(new CtClass[]{serviceCtClass});
            cc.setSuperclass(abstractStubCtClass);

            //先只实现hello这个方法
            for (Method method : serviceClass.getDeclaredMethods()) {
                List<String> strs = Arrays.stream(method.getParameterTypes()).map(Class::getName).collect(Collectors.toList());
                CtMethod ctMethod
                        = new CtMethod(
                        pool.get(method.getReturnType().getName()),
                        method.getName(),
                        pool.get(strs.toArray(new String[strs.size()])),
                        cc);
                ctMethod.setModifiers(Modifier.PUBLIC);
                ctMethod.setBody("{\n" +
                        "     return SerializeSupport.parse(invokeRemote(new RpcRequest(%s,%s,SerializeSupport.serialize(arg))));\n" +
                        "}");
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }

        return null;
    }
}
