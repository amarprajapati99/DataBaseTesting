package com.database.testing;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class DBTesting{

    public  static  Statement statement;
    public  static  Connection connection;
    static String sqlQuery;

    @BeforeTest
    public void setUpDatabase() throws ClassNotFoundException, SQLException {

        Class.forName ("com.mysql.jdbc.Driver");
        System.out.println ("driver loaded");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_data",
                "root","root");

        System.out.println ("connected my database");
        statement = connection.createStatement ();
    }

    @Test
    public void Insert_data_In_To_employee_data_Table() throws SQLException {

        sqlQuery = "insert into employee_data values ('rakesh','rkp@gmail.com')";
        statement.executeUpdate (sqlQuery);

    }

    @Test
    public void updateData_Into_employee_data_Table() throws SQLException {
        sqlQuery = "update employee_data set emailId = 'rakesh@gmail.com ' where firstName = 'rakesh' ";
        statement.executeUpdate (sqlQuery);
    }

    @Test
    public void test_WhenAData_IsDeleted_FromATable_OfDatabase() throws SQLException {
        sqlQuery = "delete from  employee_data where firstName = 'rakesh' ";
        statement.executeUpdate (sqlQuery);
    }

    @AfterTest
    public void tearDown() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
