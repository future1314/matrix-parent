/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.date;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zyy43688
 * @version $Id: DateDemo.java, v 0.1 2018年5月28日 上午11:03:07 zyy43688 Exp $
 */
public class DateDemo {
    public static void main(String[] args) {
        Date date = new Date();

        DateTime dateTime = new DateTime(2018, 5, 1, 0, 0, 0);

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("YYYY-M-d HH:mm:ss");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        System.out.println(date);

        System.out.println(simpleDateFormat1.format(date));
        System.out.println(simpleDateFormat2.format(date));

        System.out.println("分割线！");

        System.out.println(dateTime.toDateTime());

        System.out.println(simpleDateFormat1.format(dateTime.toDate()));
        System.out.println(simpleDateFormat2.format(dateTime.toDate()));
    }
}