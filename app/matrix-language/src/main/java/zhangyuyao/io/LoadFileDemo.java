/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author zyy43688
 * @version $Id: LoadFileDemo.java, v 0.1 2018年5月2日 上午11:10:42 zyy43688 Exp $
 */
public class LoadFileDemo {
    public static void main(String[] args) {
        StringBuffer sb = new LoadFileDemo().loadFileToString("E:\\vscode\\1304.json");
        System.out.println(sb);
    }

    private StringBuffer loadFileToString(String path) {
        StringBuffer sb = new StringBuffer();
        FileReader fileReader = null;

        try {
            File file = new File(path);
            fileReader = new FileReader(file);

            int ch;
            while ((ch = fileReader.read()) != -1) {
                sb.append((char) ch);
            }

            return sb;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb;
    }
}