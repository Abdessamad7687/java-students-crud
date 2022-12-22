import java.util.ArrayList;
import java.util.Scanner;

public class StudentCRUD {

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("\nStudent CRUD System");
            System.out.println("1. Display all students");
            System.out.println("2. Add a new student");
            System.out.println("3. Update a student");
            System.out.println("4. Delete a student");
            System.out.println("5. Exit program");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> listStudents();
                case 2 -> addStudent();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    System.out.println("Exiting the system !!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("ID\tName\tEmail\tCode");
            for (Student student : students) {
                System.out.println("----------------------------------------");
                System.out.println(student.getId() + "\t" + student.getName()+ "\t" + student.getEmail()+ "\t" + student.getCode());
            }
        }
    }

    private static void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student email: ");
        String email = scanner.nextLine();

        System.out.print("Enter student code: ");
        String code = scanner.nextLine();

        Student student = new Student(name, email, code);
        students.add(student);

        System.out.println("Student added successfully.");
        System.out.println("----------------------------------------");
    }

    private static void updateStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        Student student = getStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new student email: ");
        String email = scanner.nextLine();

        System.out.print("Enter new student code: ");
        String code = scanner.nextLine();
        student.setName(name);
        student.setEmail(email);
        student.setCode(code);

        System.out.println("----------------------------------------");
        System.out.println("Student updated successfully.");
        System.out.println("----------------------------------------");
    }

    private static void deleteStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        Student student = getStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        students.remove(student);
        System.out.println("----------------------------------------");
        System.out.println("Student deleted successfully.");
        System.out.println("----------------------------------------");
    }

    public static Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}

