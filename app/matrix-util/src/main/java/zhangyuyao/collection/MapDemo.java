/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author zyy43688
 * @version $Id: MapDemo.java, v 0.1 2018年6月1日 上午9:32:23 zyy43688 Exp $
 */
public class MapDemo {

    private static Map<String, List<String>> map = new TreeMap<>();

    public static void main(String[] args) {
        load();

        // 输出结果
        map.forEach((key, value) -> {
            System.out.println(key);
            for (String string : value) {
                System.out.println(string);
            }
        });
    }

    public static void load() {
        File file = new File("E:\\file\\hotel.txt");

        try {
            Scanner scanner = new Scanner(file);

            boolean flag = false;// 记录是从哪个位置结束的内层循环
            String line = "";
            while (flag || scanner.hasNext()) {

                if (flag) {
                    // line已经在内层循环赋值此处不做处理
                } else {
                    line = scanner.nextLine().trim();
                }

                if (!line.contains(" ")) {

                    // 定位到一个标志点

                    List<String> methods = new ArrayList<>();

                    flag = false;

                    while (scanner.hasNext()) {
                        String method = scanner.nextLine().trim();

                        if (method.contains(" ")) {
                            methods.add(method);
                        } else {
                            Collections.sort(methods);
                            map.put(line, methods);

                            line = method;
                            // 定位到下一个标志点，flag为true标志跳出位置为读取到下一个标志点
                            flag = true;
                            break;// 此时已经读取到了下一个定位点
                        }

                        // 正常结束的时候flag还是为false
                    }

                    if (!flag) {
                        // 正常结束已经到了文件末尾，直接跳出
                        Collections.sort(methods);
                        map.put(line, methods);

                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}