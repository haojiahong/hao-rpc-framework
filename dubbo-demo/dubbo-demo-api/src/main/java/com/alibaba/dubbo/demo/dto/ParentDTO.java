package com.alibaba.dubbo.demo.dto;

import java.io.Serializable;

/**
 * @author haojiahong created on 2019/12/17
 */
public class ParentDTO implements Serializable {

    private static final long serialVersionUID = 508896478784678546L;

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
