package StudentManagement;

import java.lang.reflect.Array;
import java.util.*;

public class StudentManagementTest {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        boolean exit = false;

        while (!exit) {
            loginMenu();
            System.out.println("Please enter your choice");
            try {
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1 -> login(users);
                    case 2 -> register(users);
                    case 3 -> System.out.println("tbc");
                    case 4 -> exit = true;
                    default -> System.out.println("Invalid input. Please enter a number between 1 and 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }
        sc.close();
    }

    public static void login(ArrayList<User> users) {
        System.out.println("Please enter username");
        String username = sc.next();
        int flag = checkUser(users, username);
        if (flag < 0) {
            System.out.println("User not found!");
        } else {
            System.out.println("Please enter password");
            String password = sc.next();
            if (password.equals(users.get(flag).getPassword())) {
                String code = getVerifyCode();
                System.out.println("Please enter the verify code " + code);
                String input = sc.next();
                if (code.equals(input)) {
                    manageStudent();
                }
            }
        }
    }

    public static void register(ArrayList<User> users) {
        users.add(new User(getUsername(users), getPassword(), getId(), getPhone()));
    }

    public static String getUsername(ArrayList<User> users) {
        String username;
        while (true) {
            System.out.println("Please enter username\nrule: length need between 3 and 15, has to be character + number, cannot be all numbers\n");
            username = sc.next();
            if (!checkUsername(username)) {
                System.out.println("Please follow the username format");
            } else if (checkUser(users, username) > 0) {
                System.out.println("username already used!\n");
            } else break;
        }
        return username;
    }

    public static String getPassword() {
        String password1;
        String password2;
        while (true) {
            System.out.println("Please enter password");
            password1 = sc.next();
            System.out.println("Please enter password again");
            password2 = sc.next();
            if (!password1.equals(password2)) {
                System.out.println("Password does not match\nPlease re-enter\n");
            } else break;
        }
        return password1;
    }

    public static String getId() {
        String id;
        while (true) {
            System.out.println("Please enter id");
            id = sc.next();
            if (!checkId(id)) {
                System.out.println("Id not accept! Please re-enter\n");
            } else break;
        }
        return id;
    }

    public static String getPhone() {
        String phone;
        while (true) {
            System.out.println("Please enter phone number");
            phone = sc.next();
            if (!checkPhone(phone)) {
                System.out.println("Phone number not accept! Please re-enter\n");
            } else break;
        }
        return phone;
    }

    public static int checkUser(ArrayList<User> users, String username) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (username.equals(user.getUsername())) return i;
        }
        return -1;
    }

    public static String getVerifyCode() {
        Random r = new Random();
        StringBuilder code = new StringBuilder();
        String charPool = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 4; i++) {
            code.append(charPool.charAt(r.nextInt(52)));
        }
        code.insert(r.nextInt(5), r.nextInt(9));
        return code.toString();
    }

    public static boolean checkUsername(String username) {
        boolean hasCharacter = false, hasNumber = false;
        int length = username.length();

        if (length < 3 || length > 15) return false;

        for (int i = 0; i < username.length(); i++) {
            if (username.charAt(i) <= 58) hasNumber = true;
            else hasCharacter = true;
        }

        return hasNumber && hasCharacter;
    }

    public static boolean checkId(String id) {
        int length = id.length();
        if (length != 18 || id.charAt(0) == 48) return false;

        for (int i = 0; i < length - 1; i++) {
            if (id.charAt(i) > 57 || id.charAt(i) < 48) return false;
        }

        char c = id.charAt(length - 1);
        return (c >= '0' && c <= '9') || c == 'x' || c == 'X';
    }

    public static boolean checkPhone(String phoneNumber) {
        int length = phoneNumber.length();
        if (length != 11 || phoneNumber.charAt(0) == 48) return false;

        for (int i = 0; i < length; i++) {
            if (phoneNumber.charAt(i) > 57 || phoneNumber.charAt(i) < 48) return false;
        }
        return true;
    }

    public static void manageStudent() {
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
    }

    public static void menu() {
        System.out.println("----------Welcome to Student Management System---------\n\n1. Add a student\n2. Delete a student\n3. Edit a student\n4. Search a student\n5. Exit\n");
    }

    public static void loginMenu() {
        System.out.println("----------Welcome to Student Management System---------\n\n1. Login\n2. Register\n3. Forget Password\n4. Exit\n");
    }

    public static boolean checkId(ArrayList<Student> list, String id) {
        for (Student stu : list) {
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
        for (Student stu : list) {
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
