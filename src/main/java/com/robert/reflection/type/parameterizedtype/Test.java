package com.robert.reflection.type.parameterizedtype;

import com.robert.reflection.util.PrintUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Test {

    public static void main(String[] args) {
        Field[] fields = ParameterizedBean.class.getDeclaredFields();

        for (Field field : fields) {
            Type type = field.getGenericType();
            boolean isParameterizedType = type instanceof ParameterizedType;
            String fieldName = field.getName();
            Class<?> clazz = field.getType();
            PrintUtils.println("name: " + fieldName + " ,clazz: " + clazz + " ,isParameterizedType: " + isParameterizedType);
        }
        try {
            getParameterizedType("map");
            getParameterizedType("viewHolder");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void getParameterizedType(String fieldName) throws NoSuchFieldException {
        Field f;
        f = ParameterizedBean.class.getDeclaredField(fieldName);
        f.setAccessible(true);
        PrintUtils.println("genericType: " + f.getGenericType());
        boolean b = f.getGenericType() instanceof ParameterizedType;
        PrintUtils.print(b);
        if (b) {
            ParameterizedType type = (ParameterizedType) f.getGenericType();
            PrintUtils.print("rawType: " + type.getRawType());
            Type[] actualTypeArguments = type.getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                PrintUtils.print("actualTypeArgument: " + actualTypeArgument);
            }
            PrintUtils.print("ownerType: " + type.getOwnerType());
        }
    }
}
