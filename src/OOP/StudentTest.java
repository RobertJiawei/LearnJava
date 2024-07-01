package OOP;

import java.util.Objects;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; ) {
            Student student = new Student();
            System.out.println("enter student id");
            String id = sc.next();
            if (!isUsed(students, id)) {
                student.setId(id);
                System.out.println("enter student name");
                String name = sc.next();
                student.setName(name);
                System.out.println("enter student age");
                int age = sc.nextInt();
                student.setAge(age);

                students[i] = student;
                i++;
            } else {
                System.out.println("student id already exist. please enter a new one");
            }
        }

        getAllInfo(students);

        System.out.println("enter the student id to delete that student");
        String deleteId = sc.next();
        deleteById(students, deleteId);

        getAllInfo(students);
    }

    public static boolean isUsed(Student[] students, String id) {
        for (Student student : students) {
            if (Objects.nonNull(student) && Objects.equals(id, student.getId())) {
                return true;
            }
        }
        return false;
    }

    public static void getAllInfo(Student[] students) {
        for (Student student : students) {
            if (Objects.isNull(student)) continue;
            System.out.println("Student Id: " + student.getId() + "\nStudent Name: " + student.getName() + "\nStudent Age: " + student.getAge() + "\n----------------\n");
        }
    }

    public static void deleteById(Student[] students, String id) {
        boolean deleteSuccess = false;
        for (int i = 0; i < students.length; i++) {
            if (Objects.equals(id, students[i].getId())) {
                students[i] = null;
                System.out.println("student deleted!");
                deleteSuccess = true;
            }
        }
        if (!deleteSuccess) {
            System.out.println("student not exist!");
        }
    }
}
