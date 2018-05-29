package com.robert.reflection.type.genericarraytype;

import com.robert.reflection.util.PrintUtils;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

public class Test {

    public static void main(String[] args) {
        Field[] fields = GenericArrayTypeBean.class.getDeclaredFields();
        for (Field field : fields) {
            Type type = field.getGenericType();
            boolean isGenericArrayType = type instanceof GenericArrayType;
            String fieldName = field.getName();
            Class<?> clazz = field.getType();
            PrintUtils.println("name: " + fieldName + " ,clazz: " + clazz + " ,isGenericArrayType: " + isGenericArrayType);
        }
        try {
            getTypeVariable("pTypeArray");
            getTypeVariable("vTypeArray");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void getTypeVariable(String fieldName) throws NoSuchFieldException {
        Field f;
        f = GenericArrayTypeBean.class.getDeclaredField(fieldName);
        f.setAccessible(true);
        PrintUtils.println("genericType: " + f.getGenericType());
        boolean b = f.getGenericType() instanceof GenericArrayType;
        PrintUtils.print(b);
        if (b) {
            GenericArrayType type = (GenericArrayType) f.getGenericType();
            PrintUtils.println("name: " + type.getTypeName());
            Type componentType = type.getGenericComponentType();
            String typeName = componentType.getTypeName();
            PrintUtils.println("componentType: " + typeName);
        }
    }
}
