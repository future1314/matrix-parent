/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.io.traditional;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author zyy43688
 * @version $Id: FileInputStreamDemo.java, v 0.1 2018年7月12日 下午5:35:44 zyy43688 Exp $
 */
@Slf4j
public class FileInputStreamDemo {

    /**
     * 路径
     */
    private static final String filePath = "E:\\idea\\matrix-parent\\app\\matrix-language\\nomal_io.txt";

    /**
     * @param args
     */
    public static void main(String[] args) {
        log.info("invoke method1");
        method1();
        System.out.println();
        log.info("invoke method2");
        method2();
    }

    /**
     * NIO
     */
    public static void method1() {
        RandomAccessFile aFile = null;

        try {
            aFile = new RandomAccessFile(filePath, "rw");

            FileChannel fileChannel = aFile.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(1024);

            int bytesRead = fileChannel.read(buf);

            System.out.println(bytesRead);

            while (bytesRead != -1) {
                buf.flip();

                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }

                buf.compact();

                bytesRead = fileChannel.read(buf);
            }
        } catch (IOException e) {
            log.error("", e);
        } finally {
            try {
                if (aFile != null) {
                    aFile.close();
                }
            } catch (IOException e) {
                log.error("", e);
            }
        }

    }

    /**
     * BIO
     */
    public static void method2() {

        InputStream inputStream = null;

        try {
            inputStream = new BufferedInputStream(new FileInputStream(filePath));

            byte[] buf = new byte[1024];

            int bytesRead = inputStream.read(buf);

            while (bytesRead != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    System.out.print((char) buf[i]);
                }
                bytesRead = inputStream.read(buf);
            }

        } catch (IOException e) {
            log.error("", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.info("", e);
                }
            }
        }
    }
}

/*
* 1.文件在哪？
* 2.文件怎么读取？
* 3.文件怎么编码？
* 
* 1.多线程读取
* 2.多线程写
* 3.多线程读写
* 4.超大文件处理
* 5.文件拆分
* 6.文件合并
* */