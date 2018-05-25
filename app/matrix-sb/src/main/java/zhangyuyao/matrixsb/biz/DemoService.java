/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.biz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zyy43688
 * @version $Id: DemoService.java, v 0.1 2018年5月10日 下午8:51:22 zyy43688 Exp $
 */
@Service
@Slf4j
public class DemoService {

    /**
     * 访问量计数器
     */
    private int count = 0;

    public void increment() {
        count++;
        log.info("this is {} invoke!", count);
    }

    public int get() {
        return count;
    }

    public int resetToNum(int num) {
        return (this.count = num);
    }
}