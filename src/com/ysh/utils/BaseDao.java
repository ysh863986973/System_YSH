package com.ysh.utils;


import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 基础DAO层，用于处理和数据库相关的操作
 *
 * 1. 通用的更新方法
 * 2. 通用的查询方法
 */
public class BaseDao {
    /*
    通用的更新方法:
    1. SQL
    2. 参数不一样

    流程:
        1. 获取数据库连接对象
        2. 预处理SQL语句
        3. 给予SQL语句参数【重点】
        4. 执行SQL语句

    方法分析:
        权限修饰 public
        返回值类型 int 数据库操作受到影响的行数
        方法名 update
        形式参数列表:
            1. SQL
            2. 对应SQL语句的参数
                a. 参数类型不确定
                    Java中所有的类都是Object类的子类
                    选择Object作为数据类型
                b. 参数个数不确定
                    基础数组
                    Object[] parameters

        public int update(String sql, Object[] parameters)

    */

    /**
     * 通过的更新方法，可以处理insert，update，delete 对应的SQL语句
     *
     * @param sql String类型SQL语句
     * @param parameters 对应当前SQL语句的参数列表
     * @return MySQL数据库操作受到影响的行数
     */
    public int update(String sql, Object[] parameters) {
        int affectedRows = 0;
        PreparedStatement preparedStatement = null;
        Connection connection = JdbcUtil.getConnection();

        try {
            preparedStatement = connection.prepareStatement(sql);

            /*
             这里需要对SQL语句进行参数赋值操作
             这里需要确定SQL语句的?有多少个，参数有多少个?

             使用JDBC提供的一种方式，参数元数据！！！
             */

            // 获取SQL语句对应的参数个数
            int parameterCount = preparedStatement.getParameterMetaData().getParameterCount();

            // 对于SQL语句参数赋值之前，需要判断一些条件。
            if (parameters != null && parameterCount == parameters.length) {
                // 利用for循环，遍历数组，处理SQL语句对应的参数
                for (int i = 0; i < parameters.length; i++) {
                    preparedStatement.setObject(i + 1, parameters[i]);
                }
            }

            affectedRows = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement);
        }

        return affectedRows;
    }

    /*
    通用查询方法方法分析
    权限修饰符 public
    泛型:
        T
    返回值类型
        void pass
        int pass
        List<T>
    方法名：
        query
    形式参数列表:
        1. String sql
        2. SQL语句对应的参数列表，Object[] parameters
        3. 不确定是什么东西
            a. 约束泛型对应的具体数据类型
            b. 参数确定了当前SQL语句查询的具体对应哪一个类对象

            T t 还行 浪费空间 利用他获取Class类对象，为所欲为！！！
            Class... initParameterTypes

            Class<T> cls
                Person.class
                T ==> Person
                cls ==> 利用反射可以为所欲为
        public <T> List<T> query(String sql, Object[] parameters, Class<T> cls)
     */

    /**
     * 通用的查询方法，返回值是一个List集合，其中保存的数据类型是指定从Class<T>
     *
     * @param sql 需要处理的SQL语句 select语句
     * @param parameters 对应的当前SQL语句的参数立碑
     * @param cls 指定Class类对象，也是当前需要处理的数据类型，【不包含基本数据类型】
     * @param <T> 泛型，用于当前操作的数据类型到底是哪一个
     * @return List集合，带有指定的数据
     */
    public <T> List<T> query(String sql, Object[] parameters, Class<T> cls) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        List<T> list = new ArrayList<>();

        Connection connection = JdbcUtil.getConnection();

        try {
            preparedStatement = connection.prepareStatement(sql);

            int parameterCount = preparedStatement.getParameterMetaData().getParameterCount();

            if (parameters != null && parameterCount == parameters.length) {
                for (int i = 0; i < parameterCount; i++) {
                    preparedStatement.setObject(i + 1, parameters[i]);
                }
            }

            // 执行SQL语句，得到结果集对象
            resultSet = preparedStatement.executeQuery();

            // 获取结果集元数据
            ResultSetMetaData metaData = resultSet.getMetaData();

            // 获取当前结果集中字段个数
            int columnCount = metaData.getColumnCount();

            // 解析数据
            while (resultSet.next()) {
                T t = cls.getConstructor(null).newInstance(null);

                for (int i = 1; i <= columnCount ; i++) {
                    // 获取字段名
                    String columnName = metaData.getColumnName(i);

                    // 取出对应数据，赋值类对象中对应成员变量
                    BeanUtils.setProperty(t, columnName, resultSet.getObject(columnName));
                }

                list.add(t);
            }
        } catch (SQLException | NoSuchMethodException | InstantiationException
                | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement, resultSet);
        }

        return list;
    }


}
