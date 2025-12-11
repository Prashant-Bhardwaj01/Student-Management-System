package com.devops.studentmgmt;

import com.devops.studentmgmt.controller.StudentController;
import com.devops.studentmgmt.model.Student;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentController controller = new StudentController();

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Get Student By ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice : ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    Student s = controller.addStudent(name, age);
                    System.out.println("Student Added -> " + s);
                    break;

                case 2:
                    System.out.println("\nAll Students:");
                    controller.getAllStudents().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    String id1 = sc.nextLine();
                    System.out.println(controller.getStudent(id1));
                    break;

                case 4:
                    System.out.print("Enter Student ID to Update: ");
                    String uid = sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();
                    controller.updateStudent(uid, newName, newAge);
                    System.out.println("Student Updated Successfully.");
                    break;

                case 5:
                    System.out.print("Enter Student ID to Delete: ");
                    String did = sc.nextLine();
                    controller.deleteStudent(did);
                    System.out.println("Deleted Successfully.");
                    break;

                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
