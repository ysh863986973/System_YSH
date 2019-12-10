package com.ysh.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 较为繁琐并且存在【通用性代码】
 * 1. 数据库连接的过程
 * 驱动加载，必要参数和获取数据库连接
 * 2. 数据库操作使用的资源关闭问题
 * <p>
 * JDBCUtil这个工具类能够给我们提供什么便利
 * 1. 自动加载驱动，预处理所有的必要参数
 * 2. 简化获取数据库连接的方法，改为getConnection();
 * 3. 简化关闭数据库连接使用的资源，改为统一的close方法
 * 4. 所有的方法都是通过类名直接调用，摆脱类对象约束，使用static修饰的静态成员方法
 *
 * @author Anonymous
 */
public class JdbcUtil {

    /**
     * 创建一个c3p0连接池核心类对象，这里会自动处理在src目录下保存的c3p0-config.xml文件
     */
    private static ComboPooledDataSource pool = new ComboPooledDataSource();

    /**
     * 静态成员方法，获取对应数据库的java.sql.Connection连接对象
     *
     * @return java.sql.Connection 数据库连接对象，如果发生意外返回null
     */
    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = pool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * 关闭数据库Connection连接对象
     *
     * @param connection java.sql.Connection 数据库连接对象
     */
    public static void close(Connection connection) {
        close(connection, null, null);
    }

    /**
     * 关闭数据库Connection连接对象，以及Statement数据库SQL语句搬运工对象
     *
     * @param connection java.sql.Connection 数据库连接对象
     * @param statement  java.sql.Statement 数据库SQL语句搬运工对象
     */
    public static void close(Connection connection, Statement statement) {
        close(connection, statement, null);
    }

    /**
     * 关闭数据库Connection连接对象，Statement数据库SQL语句搬运工对象以及查询结果集对象ResultSet
     *
     * @param connection java.sql.Connection 数据库连接对象
     * @param statement  java.sql.Statement 数据库SQL语句搬运工对象
     * @param resultSet java.sql.ResultSet 查询结果集类对象
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {

            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
