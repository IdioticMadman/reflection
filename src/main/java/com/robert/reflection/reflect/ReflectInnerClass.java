package com.robert.reflection.reflect;

import com.robert.reflection.util.PrintUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射public的内部类的private方法
 */
public class ReflectInnerClass {

    public static void main(String[] args) {
        /*
          1. 实例化外部类
          2. 实例化内部类，注意:
              a. 内部类的类名为外部类全名$内部类类名
              b. 这个时候传入外部类对象才能构造
          3. 获取内部类的method对象，设置accessible，调用method的
         */
        try {
            Class<?> outerClazz = Class.forName("com.robert.reflection.reflect.ReflectInnerClass");
            //1
            ReflectInnerClass outer = (ReflectInnerClass) outerClazz.newInstance();
            //2.a
            Class<?> innerClazz = Class.forName("com.robert.reflection.reflect.ReflectInnerClass$Inner");
            //2.b
            Constructor<?> constructor = innerClazz.getConstructor(outerClazz);
            Object inner = constructor.newInstance(outer);
            //3
            Method getAge = innerClazz.getDeclaredMethod("getAge");
            getAge.setAccessible(true);
            Object result = getAge.invoke(inner);
            PrintUtils.println("反射拿到的结果为: " + result);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public class Inner {
        private Integer getAge() {
            return 10;
        }
    }
}
