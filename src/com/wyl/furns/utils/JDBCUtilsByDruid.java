package com.wyl.furns.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 韩顺平
 * @version 1.0
 * 基于druid数据库连接池的工具类
 */
public class JDBCUtilsByDruid {

    private static DataSource ds;
    private static ThreadLocal<Connection> threadLocalconn = new ThreadLocal<>();

    //在静态代码块完成 ds初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(JDBCUtilsByDruid.class.getClassLoader().getResourceAsStream("druid.properties"));
            //properties.load(new FileInputStream("src\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //编写getConnection方法
    /*public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }*/

    public static Connection getConnection()  {

        Connection connection = threadLocalconn.get();
        if(connection==null){
            try {
                connection = ds.getConnection();
                connection.setAutoCommit(false);

            }catch (SQLException throwables){
                throwables.printStackTrace();
                }
            threadLocalconn.set(connection);


        }
        return connection;
    }



    public static void commit() {
        Connection connection = threadLocalconn.get();
        if(connection != null){
            try {
                connection.commit();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }finally{
                try{
                    connection.close();
                }catch(SQLException throwables){
                    throwables.printStackTrace();
                }
            }

        }
        threadLocalconn.remove();
    }

    public static void rollback(){
        Connection connection = threadLocalconn.get();
        if(connection != null){
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        threadLocalconn.remove();
    }


    public static void close(ResultSet resultSet, Statement statement, Connection connection) {

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
            throw new RuntimeException(e);
        }
    }
}
