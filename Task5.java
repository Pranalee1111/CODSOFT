import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Student class representing individual students
class Student implements Serializable {
    private static final long serialVersionUID = 1L; // For serialization

    private String name;
    private int rollNumber;
    private char grade;

    // Constructor
    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", grade=" + grade +
                '}';
    }
}

// StudentManagementSystem class to manage the collection of students
class StudentManagementSystem {
    private List<Student> students;

    // Constructor
    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    // Method to add a student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to remove a student
    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    // Method to search for a student
    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null; // Student not found
    }

    // Method to display all students
    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

// User interface for the Student Management System
public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search for Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();

                    System.out.print("Enter grade: ");
                    char grade = scanner.next().charAt(0);

                    Student newStudent = new Student(name, rollNumber, grade);
                    studentManagementSystem.addStudent(newStudent);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int removeRollNumber = scanner.nextInt();
                    studentManagementSystem.removeStudent(removeRollNumber);
                    System.out.println("Student removed successfully!");
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchRollNumber = scanner.nextInt();
                    Student foundStudent = studentManagementSystem.searchStudent(searchRollNumber);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    System.out.println("All Students:");
                    studentManagementSystem.displayAllStudents();
                    break;

                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
