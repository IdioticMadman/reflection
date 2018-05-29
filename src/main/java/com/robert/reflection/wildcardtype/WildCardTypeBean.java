package com.robert.reflection.wildcardtype;

import java.util.List;

public class WildCardTypeBean {

    //以下的是
    List<? extends Number> a;
    List<? super String> b;

    //以下不是
    List<String> c;
    Class<?> clazz;
}
