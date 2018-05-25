/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dubbo.impl;

import dubbo.DemoService;
import lombok.extern.java.Log;

/**
 * @author zyy43688
 * @version $Id: DemoServiceImpl.java, v 0.1 2018年5月25日 下午4:22:15 zyy43688 Exp $
 */
@Log
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        log.info("就收到的传入参数：" + name);
        return name;
    }
}