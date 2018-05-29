package com.robert.reflection.wildcardtype;

import com.robert.reflection.util.PrintUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

public class Test {

    public static void main(String[] args) {
        Field[] fields = WildCardTypeBean.class.getDeclaredFields();
        for (Field field : fields) {
            Type type = field.getGenericType();
            if (!(type instanceof ParameterizedType)) {
                PrintUtils.println("没有泛型");
                PrintUtils.println("-----------------------------------");
                continue;
            }
            PrintUtils.println("下面开始打印" + type.getTypeName() + "是否具有通配符");
            type = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (!(type instanceof WildcardType)) {
                PrintUtils.println("不具有通配符");
                PrintUtils.print("---------------------------");
                continue;
            }

            WildcardType wildcardType = (WildcardType) type;
            Type[] lowerTypes = wildcardType.getLowerBounds();
            if (lowerTypes != null) {
                PrintUtils.print("下边界");
                PrintUtils.printTypeArr(lowerTypes);
            }
            Type[] upTypes = wildcardType.getUpperBounds();
            if (upTypes != null) {
                PrintUtils.print("上边界");
                PrintUtils.printTypeArr(upTypes);
            }
            PrintUtils.print("---------------------------");
        }

    }
}
