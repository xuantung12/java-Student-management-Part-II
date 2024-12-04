/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm2;

/**
 *
 * @author PC-ACER
 */
import java.util.Scanner;

public class Mainn {
    public static void main(String[] args) {
        StudentManagers manager = new StudentManagers();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Show Student List");
            System.out.println("5. Find Student");
            System.out.println("6. Sort Students by Marks");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> manager.addStudent();
                case 2 -> manager.editStudent();
                case 3 -> manager.deleteStudent();
                case 4 -> manager.showStudentList();
                case 5 -> manager.findStudent();
                case 6 -> manager.sortStudentsByMarks();
                case 7 -> {
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}