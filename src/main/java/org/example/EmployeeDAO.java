package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAO {

    // ADD EMPLOYEE
    public void addEmployee(String name, String email, double salary, String department) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO employee (name, email, salary, department) VALUES (?, ?, ?, ?)";

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setDouble(3, salary);
            pstmt.setString(4, department);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee Added Successfully!");
            }

            pstmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // VIEW ALL EMPLOYEES
    public void getAllEmployees() {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM employee";

            PreparedStatement pstmt = con.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n===== Employee List =====");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                double salary = rs.getDouble("salary");
                String department = rs.getString("department");

                System.out.println(
                        id + " | " +
                                name + " | " +
                                email + " | " +
                                salary + " | " +
                                department
                );
            }

            rs.close();
            pstmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // UPDATE EMPLOYEE
    public void updateEmployee(int id, double salary, String department) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE employee SET salary = ?, department = ? WHERE id = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setDouble(1, salary);
            pstmt.setString(2, department);
            pstmt.setInt(3, id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee Updated Successfully!");
            } else {
                System.out.println("Employee ID not found!");
            }

            pstmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // DELETE EMPLOYEE
    public void deleteEmployee(int id) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM employee WHERE id = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee Deleted Successfully!");
            } else {
                System.out.println("Employee ID not found!");
            }

            pstmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}