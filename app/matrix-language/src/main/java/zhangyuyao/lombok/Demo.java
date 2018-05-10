/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.lombok;

import java.util.Arrays;

import lombok.Getter;
import lombok.extern.java.Log;

/**
 * @author zyy43688
 * @version $Id: LombokDemo.java, v 0.1 2018年5月9日 下午7:04:23 zyy43688 Exp $
 */
@Log
public class Demo {

    @Getter
    private String[] states = { "a", "b", "c" };

    public static void main(String[] args) {
        Demo demo = new Demo();
        log.info(Arrays.toString(demo.getStates()));

        demo.getStates()[0] = "d";
        log.info(Arrays.toString(demo.getStates()));
    }
}