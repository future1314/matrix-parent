/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

/**
 * @author zyy43688
 * @version $Id: Demo1.java, v 0.1 2018年5月11日 下午4:14:14 zyy43688 Exp $
 */
public class Demo1 {

    public List<List<String>> stringList;

    /**
     * 只是创建了一个对象
     * 
     * @param args
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Demo1 demo1 = new Demo1();

        Class<?> clazz = demo1.getClass();

        Field field = clazz.getField("stringList");

        System.out.println(field.getType());

        Type type = field.getGenericType();

        if (type instanceof Class) {
            System.out.println("Class instance");
            System.out.println(((Class) type).getName());
        } else if (type instanceof ParameterizedTypeImpl) {
            System.out.println("Parameter instance");
            System.out.println(Arrays.toString(((ParameterizedTypeImpl) type).getActualTypeArguments()));
        }

        System.out.println();

    }
}