/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.hotel;

import java.lang.reflect.Field;

/**
 * @author zyy43688
 * @version $Id: Demo.java, v 0.1 2018年5月4日 上午10:47:10 zyy43688 Exp $
 */
public class Demo {
    private Integer num = 100;

    /**
     * 
     * @param args
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 动态载入class文件
        //        Class<?> clazz = Class.forName("com.ly.flight.tmc.domestichotelcache.facade.dto.hotelListInfo.HotelListSearchResponseDTO");
        Class<?> clazz = Class.forName("zhangyuyao.hotel.Demo");

        Object object = clazz.newInstance();

        Field[] fields = clazz.getDeclaredFields();

        // 不是这个怎么加载进来呢？

        for (Field field : fields) {

            System.out.println(field.getGenericType());
        }

        //System.out.println(clazz.getSimpleName());
    }
}