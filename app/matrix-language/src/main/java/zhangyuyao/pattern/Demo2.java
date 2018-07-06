/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.pattern;

/**
 * 检测枚举类构造函数虚拟机执行了多少次
 *
 * @author zyy43688
 * @version $Id: Demo2.java, v 0.1 2018年6月21日 下午2:56:37 zyy43688 Exp $
 */
public class Demo2 {

    public static void main(String[] args) {
        System.out.println(MyEnum.A.ordinal());
    }

    private enum MyEnum {
                         A, B, C, D;

        MyEnum() {
            System.out.println("执行一次");
        }
    }
}