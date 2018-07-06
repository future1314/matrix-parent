/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.json;

import java.io.File;
import java.util.Scanner;

/**
 * @author zyy43688
 * @version $Id: JsonDemo.java, v 0.1 2018年6月1日 上午10:14:54 zyy43688 Exp $
 */
public class JsonDemo {

    public static final String data;

    static {
        data = loadData();
    }

    private static String loadData() {
        StringBuilder sb = new StringBuilder();

        try {
            Scanner scanner = new Scanner(new File("E:\\idea\\matrix-parent\\app\\matrix-util\\src\\main\\resources\\json.json"));

            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}