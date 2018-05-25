/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author zyy43688
 * @version $Id: HashMapDemo.java, v 0.1 2018年5月11日 下午9:38:03 zyy43688 Exp $
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        Map<String, String> hashTable = new Hashtable<>();

        map.put(null, null);
        hashTable.put(null, null);

        System.out.println(map.get(null));
        System.out.println(hashTable.get(null));
    }
}