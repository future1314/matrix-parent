/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package datastruct;

import java.util.function.Consumer;

/**
 * @author zyy43688
 * @version $Id: Link.java, v 0.1 2018年4月13日 下午5:39:15 zyy43688 Exp $
 */
public class Link<T> {

    private Node head;

    /**
     * 添加一个元素
     * 
     * @param element
     */
    public void add(T element) {
        if (head == null) {
            head = new Node(null, element);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(null, element);
        }
    }

    /**
     * 内部遍历
     * @param consumer
     */
    public void forEach(Consumer<T> consumer) {
        Node temp = head;

        while (temp != null) {
            consumer.accept(temp.element);
            temp = temp.next;
        }
    }

    // 新增
    // 删除
    // 修改

    private class Node {
        private Node next;
        private T    element;

        public Node(Node next, T element) {
            this.next = next;
            this.element = element;
        }
    }
}