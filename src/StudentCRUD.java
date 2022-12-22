import java.util.ArrayList;
import java.util.Scanner;

public class StudentCRUD {

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent CRUD System");
            System.out.println("1. List students");
            System.out.println("2. Add a student");
            System.out.println("3. Update a student");
            System.out.println("4. Delete a student");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> listStudents();
                case 2 -> addStudent();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    System.out.println("Exiting the system. Goodbye!");
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
            System.out.println("ID\tName");
            for (Student student : students) {
                System.out.println(student.getId() + "\t" + student.getName());
            }
        }
    }

    private static void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        Student student = new Student(name);
        students.add(student);

        System.out.println("Student added successfully.");
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
        student.setName(name);

        System.out.println("Student updated successfully.");
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

        System.out.println("Student deleted successfully.");
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

