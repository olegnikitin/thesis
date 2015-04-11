package com.edu.thesis.tests;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Created by Oleg on 12.04.2015.
 */
public class DatabaseConnectionTest {

    @Test
    public void connectionSetUpTest() {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "");
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thesis", connectionProps);

        } catch (SQLException e){}
        assertNotNull(conn);
    }

}
