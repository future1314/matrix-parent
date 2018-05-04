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
    boolean flag = true;

    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        VolatileDemo volatileDemo = new VolatileDemo();

        new Thread(volatileDemo::read).start();

        Thread.sleep(1000);

        new Thread(volatileDemo::setFlag).start();
    }

    public void setFlag() {
        this.flag = false;
        System.out.println("已经被修改为了false！");
    }

    public boolean isFlag() {
        return flag;
    }

    public void read(){
        while(flag){
            //System.out.println("ahahaha");
            //System.out.println(flag);
        }
    }
}

/*为什么这个地方的修改对主线程是里面可见的？*/