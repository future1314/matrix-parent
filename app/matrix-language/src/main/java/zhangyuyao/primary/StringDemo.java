/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.primary;

/**
 * 字符串实例
 *
 * @author zyy43688
 * @version $Id: StringDemo.java, v 0.1 2018年3月26日 上午9:42:44 zyy43688 Exp $
 */
public class StringDemo {
    private static char[] digitMap = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(intToString(Integer.MAX_VALUE));
        System.out.println(intToString(Integer.MIN_VALUE));
    }

    /**
     * 整形转String
     *
     * @param num 整形
     * @return String
     */
    public static String intToString(int num) {

        if(num == Integer.MIN_VALUE){

        }

        int size = num >= 0 ? getSize(num) : getSize(-num) + 1;

        char[] chars = new char[size];

        if (num >= 0) {
            chars[0] = '0';
        } else {
            chars[0] = '-';
        }

        int temp = num > 0 ? num : -num;

        int i = chars.length - 1;
        while (temp > 0) {
            chars[i--] = digitMap[temp % 10];
            temp /= 10;
        }

        return new String(chars);
    }

    private static int getSize(int num) {
        int i = 0;

        if (num == 0) {
            return 1;
        }

        while (num > 0) {
            num /= 10;
            i++;
        }

        return i;
    }
}