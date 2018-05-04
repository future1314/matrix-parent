/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package datastruct;

/**
 * 链表实例
 *
 * @author zyy43688
 * @version $Id: LinkDemo.java, v 0.1 2018年4月13日 下午5:54:35 zyy43688 Exp $
 */
public class LinkDemo {
    public static void main(String[] args) {
        Link<String> link = new Link<>();

        link.add("张");
        link.add("玉");
        link.add("尧");
        link.add("，");
        link.add("你");
        link.add("嗓");
        link.add("子");
        link.add("不");
        link.add("舒");
        link.add("服");
        link.add("吗");
        link.add("？");

        link.forEach(System.out::print);
    }
}