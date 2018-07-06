/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.algorithm;

/**
 * 阶乘
 *
 * @author zyy43688
 * @version $Id: FactorialDemo.java, v 0.1 2018年7月5日 下午5:46:49 zyy43688 Exp $
 */
public class FactorialDemo {

    public static void main(String[] args) {
        System.out.println(factorial(10));
    }

    /**
     * 计算阶乘
     *
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        int result = 1;

        int t = n;

        while (t > 1) {
            result *= t;
            t--;
        }

        return result;
    }
}