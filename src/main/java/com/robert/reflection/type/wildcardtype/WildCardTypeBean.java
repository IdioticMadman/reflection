package com.robert.reflection.type.wildcardtype;

import java.util.List;

public class WildCardTypeBean {

    //以下的是
    List<? extends Number> a;
    List<? super String> b;

    //以下不是
    List<String> c;
    Class<?> clazz;
}
