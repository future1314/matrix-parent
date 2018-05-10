/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.thread.volatiles;

/**
 * @author zyy43688
 * @version $Id: VolatileDemo.java, v 0.1 2018年4月13日 下午2:02:58 zyy43688 Exp $
 */
public class VolatileDemo {

    /**
     * 标记值
     */
    private boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo volatileDemo = new VolatileDemo();

        new Thread(volatileDemo::read).start();

        Thread.sleep(1000);

        new Thread(volatileDemo::setFlag).start();

        System.out.println("结束！");
    }

    private void setFlag() {
        this.flag = false;
        System.out.println("已经被修改为了false！");
    }

    private void read() {
        while (flag) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(123);
        }
    }
}