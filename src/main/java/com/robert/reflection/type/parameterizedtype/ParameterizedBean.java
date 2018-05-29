package com.robert.reflection.type.parameterizedtype;

import com.robert.reflection.Person;

import java.util.List;
import java.util.Map;

public class ParameterizedBean {
    //以下都是ParameterizedType
    Map<String, Person> map;
    List<String> list;
    Map.Entry<String, Person> entry;
    ViewHolder<Person> viewHolder;
    Class<?> clazz;


    static class ViewHolder<T> {

    }

    //以下都不是
    List notlist;
    Map notmap;
    ViewHolder notViewHolder;

}
