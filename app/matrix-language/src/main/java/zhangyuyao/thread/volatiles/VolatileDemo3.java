/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.thread.volatiles;

/**
 * @author zyy43688
 * @version $Id: VolatileDemo3.java, v 0.1 2018年4月13日 下午2:34:50 zyy43688 Exp $
 */
public class VolatileDemo3 {
    private int x = 0;

    public void read() {
        System.out.println("read被调用：" + x);
        while (x == 0) {
        }
    }

    public void write() {
        x = 1;
        System.out.println("x的值已经被修改！");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo3 volatileDemo3 = new VolatileDemo3();

        Thread t1 = new Thread(volatileDemo3::read);
        Thread t2 = new Thread(volatileDemo3::write);

        t1.start();
        Thread.sleep(1000);
        t2.start();
    }
}