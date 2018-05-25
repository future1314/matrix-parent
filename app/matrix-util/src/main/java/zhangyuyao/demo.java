/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

import com.google.gson.Gson;

/**
 * @author zyy43688
 * @version $Id: demo.java, v 0.1 2018年5月11日 下午3:30:15 zyy43688 Exp $
 */
public class demo {
    /**
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 加载类
        // 反射获取属性
        // 构造函数确定对象
        // 为属性赋值
        // 反序列化输出对象

        Class<?> clazz = Class.forName("zhangyuyao.model.SimpleArrayOrList");

        Object object = clazz.newInstance();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {

            field.setAccessible(true);

            if (field.getType().isArray()) {

                int length = 10;

                // 如果是数组
                Object o = Array.newInstance(field.getType().getComponentType(), length);
                if (field.getType().getComponentType() == int.class) {
                    for (int i = 0; i < length; i++) {
                        Array.setInt(o, i, i);
                    }
                }

                field.set(object, o);
            }
        }

        System.out.println(new Gson().toJson(object));
    }
}