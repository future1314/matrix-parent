/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

import java.util.List;

/**
 * @author zyy43688
 * @version $Id: Chinals.java, v 0.1 2018年5月31日 下午2:08:39 zyy43688 Exp $
 */
public class channels {

    /**
     * 消费者订阅channel，channel由主题、事件id组成
     */
    private List<Channel> channels;

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }
}