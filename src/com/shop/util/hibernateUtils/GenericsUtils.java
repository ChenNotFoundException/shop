package com.shop.util.hibernateUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author chenchen
 * @date 2018/10/24 19:25
 * @Content:
 */
public class GenericsUtils {
    @SuppressWarnings("unchecked")
    public static Class getGenericType(Class clazz) {
        Type genType = clazz.getGenericSuperclass();
        Type[] types = ((ParameterizedType) genType).getActualTypeArguments();
        if (!(types[0] instanceof Class)) {
            return Object.class;
        }
        return (Class) types[0];
    }

    @SuppressWarnings("unchecked")
    public static String getGenericName(Class clazz) {
        return clazz.getSimpleName();
    }
}
