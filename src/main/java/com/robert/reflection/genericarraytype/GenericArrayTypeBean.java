package com.robert.reflection.genericarraytype;

import com.robert.reflection.Person;

import java.util.List;

public class GenericArrayTypeBean<T> {

    //以下是GenericArrayType
    List<String>[] pTypeArray;
    T[] vTypeArray;

    //以下都不是GenericArrayType
    List<String> list;
    String[] strings;
    Person[] persons;
}
