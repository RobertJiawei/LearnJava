package StudentManagement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManagementTest {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        boolean exit = false;

        while (!exit) {
            menu();
            System.out.println("Please enter your choice");
            try {
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline
                switch (choice) {
                    case 1 -> addStudent(list);
                    case 2 -> deleteStudent(list);
                    case 3 -> editStudent(list);
                    case 4 -> searchStudent(list);
                    case 5 -> exit = true;
                    default -> System.out.println("Invalid input. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }
        sc.close();
    }

    public static void menu() {
        System.out.println("----------Welcome to Student Management System---------\n\n1. Add a student\n2. Delete a student\n3. Edit a student\n4. Search a student\n5. Exit\n");
    }

    public static boolean checkId(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if (stu.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public static void addStudent(ArrayList<Student> list) {
        String id;
        while (true) {
            System.out.println("Please enter the student's id");
            id = sc.next();
            if (checkId(list, id)) {
                break;
            } else {
                System.out.println("id already used\n");
            }
        }
        System.out.println("Please enter the student's name");
        String name = sc.next();
        System.out.println("Please enter the student's age");
        int age = sc.nextInt();
        System.out.println("Please enter the student's address");
        String address = sc.next();

        list.add(new Student(id, name, age, address));
        System.out.println("Student added!\n");
    }

    public static void deleteStudent(ArrayList<Student> list) {
        System.out.println("Please enter the student id: ");
        String id = sc.next();
        boolean delete = false;
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if (id.equals(stu.getId())) {
                list.remove(i);
                delete = true;
            }
        }
        if (delete) {
            System.out.println("Student " + id + " deleted\n");
        } else {
            System.out.println(id + " does not exist\n");
        }
    }

    public static void editStudent(ArrayList<Student> list) {
        System.out.println("Please enter the student id that you want to edit: ");
        String id = sc.next();
        boolean isEdit = false;
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if (id.equals(stu.getId())) {
                System.out.println("Please edit the student's name");
                String name = sc.next();
                System.out.println("Please edit the student's age");
                int age = sc.nextInt();
                System.out.println("Please edit the student's address");
                String address = sc.next();
                stu.setName(name);
                stu.setAge(age);
                stu.setAddress(address);
                System.out.println("Student info edited success.\n");
                isEdit = true;
            }
        }
        if (!isEdit) System.out.println("Student not found\n");
    }

    public static void searchStudent(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("No student in the system\n");
            return;
        }
        System.out.println("Id\t\tName\tAge\t\tAddress");
        for (Student stu : list) {
            stu.displayInfo();
        }
    }
}
