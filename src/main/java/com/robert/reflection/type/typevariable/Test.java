package com.robert.reflection.type.typevariable;

import com.robert.reflection.util.PrintUtils;

import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class Test {

    public static void main(String[] args) {
        Field[] fields = TypeVariableBean.class.getDeclaredFields();
        for (Field field : fields) {
            Type type = field.getGenericType();
            boolean isParameterizedType = type instanceof TypeVariable;
            String fieldName = field.getName();
            Class<?> clazz = field.getType();
            PrintUtils.println("name: " + fieldName + " ,clazz: " + clazz + " ,isTypeVariable: " + isParameterizedType);
        }
        try {
            getTypeVariable("key");
            getTypeVariable("value");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void getTypeVariable(String fieldName) throws NoSuchFieldException {
        Field f;
        f = TypeVariableBean.class.getDeclaredField(fieldName);
        f.setAccessible(true);
        PrintUtils.println("genericType: " + f.getGenericType());
        boolean b = f.getGenericType() instanceof TypeVariable;
        PrintUtils.print(b);
        if (b) {
            TypeVariable type = (TypeVariable) f.getGenericType();
            PrintUtils.print("name: " + type.getName());
            Type[] bounds = type.getBounds();
            for (Type bound : bounds) {
                PrintUtils.print("bounds: " + bound);
            }
            Type[] getAnnotatedBounds = type.getBounds();
            for (Type bound : getAnnotatedBounds) {
                PrintUtils.print("annotatedBounds: " + bound);
            }
            GenericDeclaration declaration = type.getGenericDeclaration();
            for (TypeVariable<?> typeVariable : declaration.getTypeParameters()) {
                PrintUtils.print("genericDeclaration: " + typeVariable);
            }
        }
    }

}
