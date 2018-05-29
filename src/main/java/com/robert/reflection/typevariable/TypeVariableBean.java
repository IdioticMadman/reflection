package com.robert.reflection.typevariable;

import java.io.Closeable;
import java.io.InputStream;
import java.util.List;

public class TypeVariableBean<K extends InputStream & Closeable, V> {
    //以下是
    //上边界指定了，就是指定的
    K key;
    //上边界没有指定，就是Object
    V value;

    //以下不是
    V[] values;
    String str;
    List<K> klist;
}
