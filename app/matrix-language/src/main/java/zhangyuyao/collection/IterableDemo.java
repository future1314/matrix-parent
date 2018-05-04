/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author zyy43688
 * @version $Id: IterableDemo.java, v 0.1 2018年4月28日 上午11:01:40 zyy43688 Exp $
 */
public class IterableDemo {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("测试开始！");

        MyList<String> myList = new MyList<>();

        // 添加元素
        myList.add("张玉尧");
        myList.add("喜欢");
        myList.add("张颖");

        /**
         * for-each遍历
         */
        for (String string : myList) {
            System.out.print(string + " ");
        }

        System.out.println();

        /**
         * for-each遍历
         */
        for (String string : myList) {
            System.out.print(string + " ");
        }

        System.out.println("\n测试结束！");
    }

}

class MyList<E> implements Iterable<E> {

    /**
     * 容量
     */
    private final int CAPACITY = 10;

    /**
     * 基于数组实现list
     */
    private Object[]  elements = new Object[CAPACITY];

    /**
     * 大小
     */
    private int       size     = 0;

    /**
     * 新增一个元素
     * @param e 元素
     */
    public void add(E e) {
        elements[size++] = e;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {

        /**
         * 
         */
        private int index = 0;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return index < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {

            if (index == size) {
                throw new NoSuchElementException();
            }

            return (E) (elements[index++]);
        }
    }
}