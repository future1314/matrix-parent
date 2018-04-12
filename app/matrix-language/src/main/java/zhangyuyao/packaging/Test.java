/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.packaging;

import zhangyuyao.packaging.sub.Chinese;

/**
 * @author zyy43688
 * @version $Id: Test.java, v 0.1 2018年3月26日 上午11:25:53 zyy43688 Exp $
 */
public class Test {
    public static void main(String[] args) {

        System.out.println(new Chinese().name);
        new Human().setName("张玉尧");
    }
}

/**
 * protected 表明被它修饰的成员变量为保护类型，在同一个包里和 public 类型是一样的，也是能够访问到的。但是如果在不同包里的 protected 类型的成员变量就只能通过子类来访问，这个修饰符是区别于其他的修饰符的。
 * <p>
 * <p>
 * （1）在java中有public、protected、private、package-private（无修饰符）四种访问级别
 * （2）在子类中的方法如果重载了父类的方法，那么该方法的可见级别应更高或者相同，如父类中的方法是protected，那么子类中方法可以是public，但不能是private。
 * （3）在java中，一般来说，变量成员最好是private，对它们的访问可以通过public的方法，在这些方法中可以做些控制以保证数据的一致性。这些方法名一般以get和set做为前缀。
 */