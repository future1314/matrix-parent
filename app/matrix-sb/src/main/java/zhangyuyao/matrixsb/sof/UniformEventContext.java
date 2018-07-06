/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

/**
 * 统一消息事件上下文
 *
 * @author zyy43688
 * @version $Id: UniformEventContext.java, v 0.1 2018年5月31日 下午1:56:42 zyy43688 Exp $
 */
public class UniformEventContext {
    private ConsumeConcurrentlyContext ccContext;
    private ConsumeOrderlyContext      coContext;

    public UniformEventContext(ConsumeConcurrentlyContext ccContext, ConsumeOrderlyContext coContext) {
        super();
        this.ccContext = ccContext;
        this.coContext = coContext;
    }

    public ConsumeConcurrentlyContext getCcContext() {
        return ccContext;
    }

    public void setCcContext(ConsumeConcurrentlyContext ccContext) {
        this.ccContext = ccContext;
    }

    public ConsumeOrderlyContext getCoContext() {
        return coContext;
    }

    public void setCoContext(ConsumeOrderlyContext coContext) {
        this.coContext = coContext;
    }
}