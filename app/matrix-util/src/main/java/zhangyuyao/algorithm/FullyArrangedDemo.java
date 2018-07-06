/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.algorithm;

/**
 * 全排列
 *
 * @author zyy43688
 * @version $Id: FullyArrangedDemo.java, v 0.1 2018年7月5日 下午5:51:14 zyy43688 Exp $
 */
public class FullyArrangedDemo {

    public static long num = 0;

    public static void main(String[] args) {
        // 针对0~9的全排列

        for (long i = 123456789; i <= 9876543210L; i++) {

            boolean flag = true;

            int[] digits = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

            for (int j = 1; j <= 10; j++) {
                if (isUsed(digits, i, j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println(i);
                num++;
            }
        }

        System.out.println(num);
    }

    private static boolean isUsed(int[] digits, long i, int j) {
        int number = 0;

        while (j > 1) {
            i /= 10;
            j--;
        }

        number = (int) (i % 10);

        if (digits[number] == 1) {
            return true;
        } else {
            digits[number] = 1;
            return false;
        }
    }
}