package com.gyx.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    /**
     * 注入参数到bean中
     *
     * @param map  参数的map，存的是每个参数的值，如{name:Java}表示名字是Java
     * @param bean bean
     */
    public static <T> T copyParamToBean(T bean, Map map) {
        try {
            BeanUtils.populate(bean, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String str, int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            return defaultValue;
        }
    }
}
