package com.robert.reflection.dynamicproxy.other;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Subject subject = (Subject) Proxy.newProxyInstance(
                Client.class.getClassLoader(),
                new Class[]{Subject.class},
                new SubjectProxy(RealSubject.get()));
        subject.rent();
        subject.hello("robert");
    }
}