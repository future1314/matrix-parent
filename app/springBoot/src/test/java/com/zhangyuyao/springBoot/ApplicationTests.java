package com.zhangyuyao.springBoot;

import com.zhangyuyao.springBoot.service.ServiceDemo;
import com.zhangyuyao.springBoot.transaction.biz.CountService;
import com.zhangyuyao.springBoot.transaction.model.Counter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private ServiceDemo serviceDemo;

    @Autowired
    private CountService countService;

    @Test
    public void contextLoads() {
        serviceDemo.say();
    }

    /**
     * 测试转账（正常转账）
     */
    @Test
    public void testTransfer() {
        countService.transfer(new Counter("AA"), new Counter("BB"), 100);
    }

    /**
     * 事物控制下的转账
     */
    @Test
    public void testTransferWithTransaction() {
        countService.transferWithTransaction(new Counter("AA"), new Counter("BB"), 200);
    }

    /**
     * 事物控制下的转账
     */
    @Test
    public void testTransferWithTransactionByAnnotation() throws Exception {
        countService.transferWithTransactionByAnnotation(new Counter("AA"), new Counter("BB"), 200);
    }
}