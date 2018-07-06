/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

/**
 * Consumer从哪里开始消费
 * 
 * @author zyy43688
 * @version $Id: ConsumeFromWhere.java, v 0.1 2018年5月31日 下午2:17:38 zyy43688 Exp $
 */
public enum ConsumeFromWhere {
                              /**
                               * 一个新的订阅组第一次启动从队列的最后位置开始消费
                               * 后继再启动接着上次消费的进度开始消费
                               */
                              CONSUME_FROM_LAST_OFFSET,

                              /**
                               * 一个新的订阅组第一次启动从队列的最前位置开始消费
                               * 后继再启动接着上次消费的进度开始消费
                               */
                              CONSUME_FROM_FIRST_OFFSET,

                              /**
                               * 一个新的订阅组第一次启动从指定时间开始消费
                               * 后续再启动接着上次消费的进度开始消费
                               * 时间点设置参见 DefaultMQPushConsumer.consumeTimestamp参数
                               */
                              CONSUME_FROM_TIMESTAMP
}