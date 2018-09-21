package com.zhangyuyao.springBoot;

import com.zhangyuyao.springBoot.mq.producer.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 张玉尧（matrix.zhang@ximalaya.com）
 * @version $Id: HelloApplicationTests.java, v 0.1 2018年9月3日 下午3:49:57 张玉尧（matrix.zhang@ximalaya.com） Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:MyApplication.xml")
public class HelloApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    public void hello() throws Exception {
        sender.send();
    }

}
