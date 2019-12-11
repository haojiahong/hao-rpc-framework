package com.hjh.hao.rpc.spi;

import java.lang.annotation.*;

/**
 * @author haojiahong created on 2019/12/9
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Singleton {

}
