/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.review;

/**
 * 检测字符串仅仅包含数字
 *
 * @author zyy43688
 * @version $Id: OnlyMemberDemo.java, v 0.1 2018年6月4日 下午5:08:13 zyy43688 Exp $
 */
public class OnlyMemberDemo {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        String string = "32222222222222";
        System.out.println(isOnlyNumber(string));
    }

    /**
     * 
     * @param string
     * @return
     */
    private static boolean isOnlyNumber(String string) {

        for (int i = 0; i < string.length(); i++) {
            if ('0' <= string.charAt(i) && string.charAt(i) <= '9') {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}