/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.io;

import java.io.File;
import java.util.Scanner;

/**
 * @author zyy43688
 * @version $Id: LoadFile.java, v 0.1 2018年5月29日 下午2:34:26 zyy43688 Exp $
 */
public class LoadFile {
    public static void main(String[] args) {
        File file = new File("E:\\file\\resource.txt");

        try {

            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine().substring(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}