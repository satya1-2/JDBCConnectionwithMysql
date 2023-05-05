
package com.bridgelabz.jdbc;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeePayroll extends BaseClass {
    public void retrieveEmployeePayrollData() throws SQLException {
        connection = setUpDatabase();
        Statement statement = connection.createStatement();
        String query = "select * from employeepayroll";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String gender = resultSet.getString(3);
            double salary = resultSet.getDouble(4);
            String date_info = resultSet.getString(5);
            System.out.println(id + " " + name + " " + gender + " " + salary + " " + date_info);
        }

        System.out.println("Retrieve all the employee payroll data");
    }

    public void insertEmployeePayrollData() throws SQLException {
        connection = setUpDatabase();
        String insertQuery = "Insert into employeepayroll (name, gender,salary,date_info )values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, "Terrisa");
        preparedStatement.setString(2, "f");
        preparedStatement.setDouble(3, 25000000.00);
        preparedStatement.setString(4, "2020-05-01");
        preparedStatement.execute();

        System.out.println("Record added successfully");
    }

    public void updateEmployeePayrollData() throws SQLException {
        connection = setUpDatabase();
        String updateQuery = "update employeepayroll set salary = 3000000.00 WHERE name = 'Terrisa'";
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
        preparedStatement.executeUpdate();
        System.out.println("Record updated successfully");
    }

    public void updateWithPreparedStatementEmployeePayrollData() throws SQLException {
        connection = setUpDatabase();
        String updateQuery = "update employeepayroll set salary = ? WHERE name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
        preparedStatement.setDouble(1, 3000000.00);
        preparedStatement.setString(2, "Terrisa");
        preparedStatement.executeUpdate();
        System.out.println("Record updated successfully");
    }

    public void deleteEmployeePayroll() throws SQLException {
        connection = setUpDatabase();
        String deleteQuery = "Delete from employeepayroll where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setInt(1, 5);
        preparedStatement.executeUpdate();
        System.out.println("Record deleted successfully");
    }


    public void findDataBetweenGivenDateRange() throws SQLException {
        connection = setUpDatabase();
        String sumQuery = "select * from employeepayroll where date_info BETWEEN cast('2021-03-25' as Date) and DATE(NOW())";
        Statement statement = connection.createStatement();
        ResultSet count = statement.executeQuery(sumQuery);
        while (count.next()) {
            System.out.println("id " + count.getInt(1));
            System.out.println("name " + count.getString(2));
            System.out.println("gender " + count.getString(3));
            System.out.println("salary " + count.getDouble(4));
            System.out.println("date_info " + count.getString(5));

        }
        System.out.println("Record updated successfully" + count);
    }


    public void sumOFGivenSalary() throws SQLException {
        connection = setUpDatabase();
        String sumOfQuery = "select SUM(salary) from employeepayroll where gender = 'M' group by gender";
        Statement statement = connection.createStatement();
        ResultSet count = statement.executeQuery(sumOfQuery);
        while (count.next()) {
            System.out.println("id " + count.getInt(1));
            System.out.println("name " + count.getString(2));
            System.out.println("gender " + count.getString(3));
            System.out.println("salary " + count.getDouble(4));
            System.out.println("date_info " + count.getString(5));

        }
        System.out.println("Record updated successfully" + count);
    }


    public void maxOfGivenSalary() throws SQLException {
        connection = setUpDatabase();
        String maxOfQuery = "select max(salary) from employeepayroll where gender = 'M' group by gender;";
        Statement statement = connection.createStatement();
        ResultSet counts = statement.executeQuery(maxOfQuery);
        while (counts.next()) {
            System.out.println("id " + counts.getInt(1));
            System.out.println("name " + counts.getString(2));
            System.out.println("gender " + counts.getString(3));
            System.out.println("salary " + counts.getDouble(4));
            System.out.println("date_info " + counts.getString(5));


        }
        System.out.println("Record updated successfully" + counts);
    }

    public void minOfGivenSalary() throws SQLException {
        connection = setUpDatabase();
        String maxOfQuery = "select min(salary) from employeepayroll where gender = 'M'   group by gender;";
        Statement statement = connection.createStatement();
        ResultSet countss = statement.executeQuery(maxOfQuery);
        while (countss.next()) {
            System.out.println("id " + countss.getInt(1));
            System.out.println("name " + countss.getString(2));
            System.out.println("gender " + countss.getString(3));
            System.out.println("salary " + countss.getDouble(4));
            System.out.println("date_info " + countss.getString(5));


        }
        System.out.println("Record updated successfully" + countss);
    }

    public void avgOfGivenSalary() throws SQLException {
        connection = setUpDatabase();
        String maxOfQuery = "select avg(salary) from employeepayroll where gender = 'M'   group by gender;";
        Statement statement = connection.createStatement();
        ResultSet countsss = statement.executeQuery(maxOfQuery);
        while (countsss.next()) {
            System.out.println("id " + countsss.getInt(1));
            System.out.println("name " + countsss.getString(2));
            System.out.println("gender " + countsss.getString(3));
            System.out.println("salary " + countsss.getDouble(4));
            System.out.println("date_info " + countsss.getString(5));


        }
        System.out.println("Record updated successfully" + countsss);
    }

    public void countOfGivenSalary() throws SQLException {
        connection = setUpDatabase();
        String maxOfQuery = "select count(salary) from employeepayroll where gender = 'M'   group by gender;";
        Statement statement = connection.createStatement();
        ResultSet countsalary = statement.executeQuery(maxOfQuery);
        while (countsalary.next()) {
            System.out.println("id " + countsalary.getInt(1));
            System.out.println("name " + countsalary.getString(2));
            System.out.println("gender " + countsalary.getString(3));
            System.out.println("salary " + countsalary.getDouble(4));
            System.out.println("date_info " + countsalary.getString(5));


        }
        System.out.println("Record updated successfully" + countsalary);
    }
}