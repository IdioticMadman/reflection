package com.robert.reflection.util;

import java.lang.reflect.Type;

public class PrintUtils {
    public static void println(Object str) {
        System.out.println(str);
    }

    public static void print(Object str) {
        System.out.println(str);
    }

    public static void printTypeArr(Type[] lowerTypes) {
        StringBuilder sb = new StringBuilder();
        for (Type lowerType : lowerTypes) {
            sb.append(lowerType.getTypeName()).append(", ");
        }
        System.out.println(sb.toString());
    }
}
