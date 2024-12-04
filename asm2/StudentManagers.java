/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm2;

/**
 *
 * @author PC-ACER
 */
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagers {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Marks: ");
        double marks = scanner.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    public void editStudent() {
        System.out.print("Enter Student ID to edit: ");
        int id = scanner.nextInt();
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.print("Enter new Marks: ");
                double newMarks = scanner.nextDouble();
                student.setMarks(newMarks);
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void showStudentList() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        System.out.println("=== Student List ===");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void findStudent() {
        System.out.print("Enter Student Name to search: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public void sortStudentsByMarks() {
        System.out.println("Choose sorting algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Insertion Sort");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> bubbleSort();
            case 2 -> insertionSort();
            default -> {
                System.out.println("Invalid choice. Defaulting to Bubble Sort.");
                bubbleSort();
            }
        }
        System.out.println("Students sorted successfully!");
        showStudentList();
    }

    private void bubbleSort() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getMarks() > students.get(j + 1).getMarks()) {
                    // Swap
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }

    private void insertionSort() {
        int n = students.size();
        for (int i = 1; i < n; i++) {
            Student key = students.get(i);
            int j = i - 1;

            // Move elements that are greater than key to one position ahead of their current position
            while (j >= 0 && students.get(j).getMarks() > key.getMarks()) {
                students.set(j + 1, students.get(j));
                j = j - 1;
            }
            students.set(j + 1, key);
        }
    }
}
