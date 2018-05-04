/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.thread.volatiles;

/**
 * @author zyy43688
 * @version $Id: VolatileDemo2.java, v 0.1 2018年4月13日 下午2:18:42 zyy43688 Exp $
 */
public class VolatileDemo2 {

    private int x = 1;

    public void process() {
        x = 0;
        System.out.println("x已经被修改为了0");
    }

    public static void main(String[] args) {
        VolatileDemo2 volatileDemo = new VolatileDemo2();

        new Thread(() -> {
            System.out.println("线程2检测到的值：" + volatileDemo.getX());
            while (volatileDemo.getX() != 0) {
                System.out.println("未检测到值修改！");
            }
        }).start();

        new Thread(volatileDemo::process).start();

    }

    public int getX() {
        return x;
    }
}