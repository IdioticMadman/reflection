package com.robert.reflection.dynamicproxy.other;

public class RealSubject implements Subject {

    public static RealSubject get() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        static final RealSubject INSTANCE = new RealSubject();
    }

    public static RealSubject call() {
        return Holder.INSTANCE;
    }

    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str) {
        System.out.println("hello " + str);
    }
}