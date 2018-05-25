/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: ConnectionDemo.java, v 0.1 2018年5月23日 下午4:20:13 zyy43688 Exp $
 */
@Slf4j
public class ConnectionDemo {

    /**
     * 记录链接数量
     */
    private static int                      count       = 0;

    /**
     * 记录链接对象的hashCode值，主要是判断是否是创建新的链接对象
     */
    private static Set<Integer>             hashCodes   = new HashSet<>();

    /**
     * 保存连接数，目的是防止GC（如果在超过连接数之前发生了GC，将无法准确的模拟出超过连接数的现象）
     */
    private static Map<Integer, Connection> connections = new HashMap<>();

    /**
     * JDBC链接字符串
     */
    private static final String             url         = "jdbc:mysql://localhost:3306/matrix?useUnicode=true&characterEncoding=UTF8&useSSL=false";

    /**
     * 用户名
     */
    private static final String             username    = "root";

    /**
     * 密码
     */
    private static final String             password    = "225821zyy";

    public static void main(String[] args) throws SQLException {
        // MySQL支持的最大连接数是151
        for (int i = 0; i < 153; i++) {
            getConnection();
        }
        log.info("hashCode总数为：{}", hashCodes.size());
    }

    public static Connection getConnection() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                count++;
            }
        } catch (SQLException e) {
            // 仅仅是捕获异常并且打印输出，没有做任何的特殊处理
            e.printStackTrace();
        }

        if (connection == null) {
            return null;
        }

        log.info("第{}个链接对象的hashcode为{}", count, connection.hashCode());

        hashCodes.add(connection.hashCode());
        connections.put(connection.hashCode(), connection);

        return connection;
    }
}