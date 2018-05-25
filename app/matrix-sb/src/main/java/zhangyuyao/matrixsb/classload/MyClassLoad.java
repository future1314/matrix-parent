/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.classload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zyy43688
 * @version $Id: MyClassLoad.java, v 0.1 2018年5月17日 下午5:24:42 zyy43688 Exp $
 */
public class MyClassLoad extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("E:\\Demo.class");

        List<Byte> byteList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);

            int b;
            while ((b = fileInputStream.read()) != -1) {
                byteList.add((byte) b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] bytes = new byte[byteList.size()];

        for (int i = 0; i < byteList.size(); i++) {
            bytes[i] = byteList.get(i);
        }

        return defineClass(name, bytes, 0, bytes.length);
    }
}