package com.robert.reflection.dynamicproxy;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        IApi iApi = (IApi) Proxy.newProxyInstance(Test.class.getClassLoader(), new Class[]{IApi.class},
                (proxy, method, args1) -> {
                    System.out.println(method.getName() + "被调用");
                    return null;
                });

        iApi.getAge();
    }
}
