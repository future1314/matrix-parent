/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.jvm;

/**
 * @author zyy43688
 * @version $Id: StackOverFlowErrorDemo.java, v 0.1 2018年5月28日 下午8:09:21 zyy43688 Exp $
 */
public class StackOverFlowErrorDemo {
    public static void main(String[] args) {
        function();
    }

    private static void function(){
        System.out.println("function");
        function();
    }
}