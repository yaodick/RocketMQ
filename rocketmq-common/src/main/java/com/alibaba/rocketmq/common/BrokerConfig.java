/**
 * Copyright (C) 2010-2013 Alibaba Group Holding Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.rocketmq.common;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.alibaba.rocketmq.common.annotation.ImportantField;
import com.alibaba.rocketmq.common.constant.PermName;
import com.alibaba.rocketmq.remoting.common.RemotingUtil;


/**
 * 服务器配置
 * 
 * @author shijia.wxr<vintage.wang@gmail.com>
 */
public class BrokerConfig {
    private String rocketmqHome = System.getProperty(MixAll.ROCKETMQ_HOME_PROPERTY,
        System.getenv(MixAll.ROCKETMQ_HOME_ENV));
    private String namesrvAddr = System.getProperty(MixAll.NAMESRV_ADDR_PROPERTY,
        System.getenv(MixAll.NAMESRV_ADDR_ENV));
    private String brokerIP1 = RemotingUtil.getLocalAddress();
    private String brokerIP2 = RemotingUtil.getLocalAddress();
    @ImportantField
    private String brokerName = localHostName();
    @ImportantField
    private String brokerClusterName = "C01";
    @ImportantField
    private long brokerId = MixAll.MASTER_ID;
    private int brokerPermission = PermName.PERM_READ | PermName.PERM_WRITE;
    private int defaultTopicQueueNums = 8;
    // 自动创建Topic功能是否开启（线上建议关闭）
    @ImportantField
    private boolean autoCreateTopicEnable = true;
    // 自动创建以集群名字命名的Topic功能是否开启
    private boolean clusterTopicEnable = true;
    // 自动创建订阅组功能是否开启（线上建议关闭）
    @ImportantField
    private boolean autoCreateSubscriptionGroup = true;

    private int sendMessageThreadPoolNums = 32 + Runtime.getRuntime().availableProcessors() * 4;
    private int pullMessageThreadPoolNums = 32 + Runtime.getRuntime().availableProcessors() * 4;
    private int adminBrokerThreadPoolNums = 8;

    private String topicConfigPath = System.getProperty("user.home") + File.separator + "store"
            + File.separator + "config" + File.separator + "topics.json";

    private String consumerOffsetPath = System.getProperty("user.home") + File.separator + "store"
            + File.separator + "config" + File.separator + "consumerOffset.json";

    private String brokerConfigPath = System.getProperty("user.home") + File.separator + "store"
            + File.separator + "config" + File.separator + "broker.properties";

    private String subscriptionGroupPath = System.getProperty("user.home") + File.separator + "store"
            + File.separator + "config" + File.separator + "subscriptionGroup.json";

    private int flushConsumerOffsetInterval = 1000 * 5;

    private int flushConsumerOffsetHistoryInterval = 1000 * 60;

    // 查询消息最大时间跨度，单位小时
    private long queryMessageMaxTimeSpan = 6;

    // 是否拒接接收事务消息
    @ImportantField
    private boolean rejectTransactionMessage = false;


    public static String localHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return "DEFAULT_BROKER";
    }


    public String getRocketmqHome() {
        return rocketmqHome;
    }


    public void setRocketmqHome(String rocketmqHome) {
        this.rocketmqHome = rocketmqHome;
    }


    public String getBrokerName() {
        return brokerName;
    }


    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }


    public int getBrokerPermission() {
        return brokerPermission;
    }


    public void setBrokerPermission(int brokerPermission) {
        this.brokerPermission = brokerPermission;
    }


    public int getDefaultTopicQueueNums() {
        return defaultTopicQueueNums;
    }


    public void setDefaultTopicQueueNums(int defaultTopicQueueNums) {
        this.defaultTopicQueueNums = defaultTopicQueueNums;
    }


    public boolean isAutoCreateTopicEnable() {
        return autoCreateTopicEnable;
    }


    public void setAutoCreateTopicEnable(boolean autoCreateTopic) {
        this.autoCreateTopicEnable = autoCreateTopic;
    }


    public String getBrokerClusterName() {
        return brokerClusterName;
    }


    public void setBrokerClusterName(String brokerClusterName) {
        this.brokerClusterName = brokerClusterName;
    }


    public String getBrokerIP1() {
        return brokerIP1;
    }


    public void setBrokerIP1(String brokerIP1) {
        this.brokerIP1 = brokerIP1;
    }


    public String getBrokerIP2() {
        return brokerIP2;
    }


    public void setBrokerIP2(String brokerIP2) {
        this.brokerIP2 = brokerIP2;
    }


    public int getSendMessageThreadPoolNums() {
        return sendMessageThreadPoolNums;
    }


    public void setSendMessageThreadPoolNums(int sendMessageThreadPoolNums) {
        this.sendMessageThreadPoolNums = sendMessageThreadPoolNums;
    }


    public int getPullMessageThreadPoolNums() {
        return pullMessageThreadPoolNums;
    }


    public void setPullMessageThreadPoolNums(int pullMessageThreadPoolNums) {
        this.pullMessageThreadPoolNums = pullMessageThreadPoolNums;
    }


    public int getAdminBrokerThreadPoolNums() {
        return adminBrokerThreadPoolNums;
    }


    public void setAdminBrokerThreadPoolNums(int adminBrokerThreadPoolNums) {
        this.adminBrokerThreadPoolNums = adminBrokerThreadPoolNums;
    }


    public String getTopicConfigPath() {
        return topicConfigPath;
    }


    public void setTopicConfigPath(String topicConfigPath) {
        this.topicConfigPath = topicConfigPath;
    }


    public String getConsumerOffsetPath() {
        return consumerOffsetPath;
    }


    public void setConsumerOffsetPath(String consumerOffsetPath) {
        this.consumerOffsetPath = consumerOffsetPath;
    }


    public int getFlushConsumerOffsetInterval() {
        return flushConsumerOffsetInterval;
    }


    public void setFlushConsumerOffsetInterval(int flushConsumerOffsetInterval) {
        this.flushConsumerOffsetInterval = flushConsumerOffsetInterval;
    }


    public int getFlushConsumerOffsetHistoryInterval() {
        return flushConsumerOffsetHistoryInterval;
    }


    public void setFlushConsumerOffsetHistoryInterval(int flushConsumerOffsetHistoryInterval) {
        this.flushConsumerOffsetHistoryInterval = flushConsumerOffsetHistoryInterval;
    }


    public String getBrokerConfigPath() {
        return brokerConfigPath;
    }


    public void setBrokerConfigPath(String brokerConfigPath) {
        this.brokerConfigPath = brokerConfigPath;
    }


    public boolean isClusterTopicEnable() {
        return clusterTopicEnable;
    }


    public void setClusterTopicEnable(boolean clusterTopicEnable) {
        this.clusterTopicEnable = clusterTopicEnable;
    }


    public String getNamesrvAddr() {
        return namesrvAddr;
    }


    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }


    public long getBrokerId() {
        return brokerId;
    }


    public void setBrokerId(long brokerId) {
        this.brokerId = brokerId;
    }


    public boolean isAutoCreateSubscriptionGroup() {
        return autoCreateSubscriptionGroup;
    }


    public void setAutoCreateSubscriptionGroup(boolean autoCreateSubscriptionGroup) {
        this.autoCreateSubscriptionGroup = autoCreateSubscriptionGroup;
    }


    public String getSubscriptionGroupPath() {
        return subscriptionGroupPath;
    }


    public void setSubscriptionGroupPath(String subscriptionGroupPath) {
        this.subscriptionGroupPath = subscriptionGroupPath;
    }


    public long getQueryMessageMaxTimeSpan() {
        return queryMessageMaxTimeSpan;
    }


    public void setQueryMessageMaxTimeSpan(long queryMessageMaxTimeSpan) {
        this.queryMessageMaxTimeSpan = queryMessageMaxTimeSpan;
    }


    public boolean isRejectTransactionMessage() {
        return rejectTransactionMessage;
    }


    public void setRejectTransactionMessage(boolean rejectTransactionMessage) {
        this.rejectTransactionMessage = rejectTransactionMessage;
    }
}
