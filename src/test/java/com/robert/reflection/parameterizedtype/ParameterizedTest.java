package com.robert.reflection.parameterizedtype;

import com.robert.reflection.type.parameterizedtype.ParameterizedBean;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

public class ParameterizedTest {

    @Test
    public void testParameterized() {
        Field[] fields = ParameterizedBean.class.getDeclaredFields();
        for (Field field : fields) {
            boolean isParameterizedType = field.getGenericType() instanceof ParameterizedType;
            Assert.assertTrue(isParameterizedType);
        }
    }

}
