package com.database.testing;

import com.bridgelabz.db.testing.base.DatabaseConnection;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;

public class DBTesting extends DatabaseConnection{

    static String sqlQuery;

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
    public void updateData_Into_employee_data_Table() {
        try {
            sqlQuery = "update employees_data set mobile_number = '8888888888' where id = '1';";
            int noOfRowsAffected = statement.executeUpdate(sqlQuery);

            Assert.assertEquals(noOfRowsAffected, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_WhenAData_IsDeleted_FromATable_OfDatabase(){
        try {

            sqlQuery = "delete from employees_data where id = '3'";
            int noOfRowsAffected = statement.executeUpdate(sqlQuery);
            Assert.assertEquals(noOfRowsAffected, 1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
