
package com.bridgelabz.jdbc;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeePayroll extends BaseClass {
    public void retrieveEmployeePayrollData() throws SQLException {
        connection = setUpDatabase();
        // Statement statement = connection.createStatement();
        Statement statement = connection.createStatement();
        String query = "select * from employeepayroll";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String gender = resultSet.getString(3);
            double salary = resultSet.getDouble(4);
            String date_info = resultSet.getString(5);
            System.out.println(id + " " + name + " " +gender + " " + salary + " " + date_info);
        }

        System.out.println("Retrieve all the employee payroll data");
    }


}