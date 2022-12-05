package com.wyl.furns.test;

import com.wyl.furns.utils.JDBCUtilsByDruid;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtilsByDruidTest {
    @Test
    public void getConnection() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println("connection: "+connection);
        JDBCUtilsByDruid.close(null,null,connection);
    }
}
