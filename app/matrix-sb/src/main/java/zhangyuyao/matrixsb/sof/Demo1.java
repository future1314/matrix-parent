/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

import java.io.File;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: Demo1.java, v 0.1 2018年5月17日 上午10:50:31 zyy43688 Exp $
 */
@Slf4j
public class Demo1 {
    public static void main(String[] args) throws IOException {
        System.out.println(new File("").getCanonicalPath());
    }
}