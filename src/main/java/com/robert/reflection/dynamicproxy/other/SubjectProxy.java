package com.robert.reflection.dynamicproxy.other;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectProxy implements InvocationHandler {

    private RealSubject mRealSubject;

    public SubjectProxy(RealSubject realSubject) {
        mRealSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(mRealSubject, args);
    }
}
