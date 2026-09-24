package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeDAO dao = new EmployeeDAO();

        while (true) {

            System.out.println("\n================================");
            System.out.println("   EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();


            // ADD
            if (choice == 1) {

                System.out.print("Enter name: ");
                String name = sc.nextLine();

                System.out.print("Enter email: ");
                String email = sc.nextLine();

                System.out.print("Enter salary: ");
                double salary = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter department: ");
                String department = sc.nextLine();

                dao.addEmployee(name, email, salary, department);
            }


            // VIEW
            else if (choice == 2) {

                dao.getAllEmployees();
            }


            // UPDATE
            else if (choice == 3) {

                System.out.print("Enter employee ID: ");
                int id = sc.nextInt();

                System.out.print("Enter new salary: ");
                double salary = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter new department: ");
                String department = sc.nextLine();

                dao.updateEmployee(id, salary, department);
            }


            // DELETE
            else if (choice == 4) {

                System.out.print("Enter employee ID to delete: ");
                int id = sc.nextInt();
                sc.nextLine();

                dao.deleteEmployee(id);
            }


            // EXIT
            else if (choice == 5) {

                System.out.println("Thank you for using Employee Management System!");
                break;
            }


            // INVALID CHOICE
            else {

                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}