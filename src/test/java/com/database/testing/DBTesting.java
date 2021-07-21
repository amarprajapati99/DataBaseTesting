package com.database.testing;

import org.testng.Assert;
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

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify_data",
                "root","root");

        System.out.println ("connected my database");
        statement = connection.createStatement ();
    }

    @Test
    public void Insert_data_In_To_employee_data_Table()  {
        try {
            sqlQuery = "insert into employees_data (id, firstName, mobile_number, salary) " +
                    "values(1, 'Prahlad', '8052636931', 40000.00), (2, 'ravi', '9450807415', 30000.00)," +
                    "(3, 'jay', '9995559900', 35000.00);";

            int noOfRowsAffected = statement.executeUpdate(sqlQuery);
            Assert.assertEquals(noOfRowsAffected, 3);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateData_Into_employee_data_Table() throws SQLException {
        try {
            sqlQuery = "update employees_data set mobile_number = '8888888888' where id = '2';";
            int noOfRowsAffected = statement.executeUpdate(sqlQuery);

            Assert.assertEquals(noOfRowsAffected, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_WhenAData_IsDeleted_FromATable_OfDatabase() throws SQLException {
        try {

            sqlQuery = "delete from employees_data where id = '3'";
            int noOfRowsAffected = statement.executeUpdate(sqlQuery);
            Assert.assertEquals(noOfRowsAffected, 1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
