package com.bridgelabz.jdbc;

//import com.sun.jdi.connect.spi.Connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class BaseClass {

    public static Connection connection;

    public static void main(String[] args) throws SQLException {
        EmployeePayroll employeePayroll = new EmployeePayroll();
        employeePayroll.retrieveEmployeePayrollData();
        employeePayroll.insertEmployeePayrollData();
        employeePayroll.updateEmployeePayrollData();
        employeePayroll.updateWithPreparedStatementEmployeePayrollData();
        employeePayroll.deleteEmployeePayroll();
        employeePayroll.findDataBetweenGivenDateRange();
        listOfDrivers();
        setUpDatabase();

    }

    public static Connection setUpDatabase() {
        String jdbcURL = "jdbc:mysql://localhost:3306/studentinfo";
        String username = "root";
        String password = "Satya1234567";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver is loaded successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

            throw new IllegalStateException("Cannot load the driver successfully" + e);
        }

        try {
            System.out.println("Databases connected to the database: " + jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connection established successfully" + connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void listOfDrivers() {
        Enumeration<Driver> enumeration = DriverManager.getDrivers();
        while (enumeration.hasMoreElements()) {
            Driver driver = enumeration.nextElement();
            System.out.println("  " + driver.getClass().getName());
        }
    }

}