package codsoft;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int roll;
    private String grade;

    public Student(String name, int roll, String grade) {
        this.name = name;
        this.roll = roll;
        this.grade = grade;
    }

    public int getRoll() {
        return roll;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll: " + roll + ", Grade: " + grade;
    }
}

class StudManagementSystem {
    private List<Student> students;

    public StudManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean removeStudent(int roll) {
        for (Student student : students) {
            if (student.getRoll() == roll) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public Student searchStudent(int roll) {
        for (Student student : students) {
            if (student.getRoll() == roll) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return students;
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudManagementSystem sms = new StudManagementSystem();
        System.out.println("****STUDENT MANAGEMENT SYSTEM****");
        
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int ch = scanner.nextInt();

            switch (ch) {
                case 1:
                    scanner.nextLine(); 
                    System.out.print("Enter student name: ");
                    String n = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int r = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter grade: ");
                    String g = scanner.nextLine();
                    Student newStudent = new Student(n, r, g);
                    sms.addStudent(newStudent);
                    System.out.println("Student added.");
                    break;

                case 2:
                    System.out.print("Enter roll number of student to remove: ");
                    int rollToRemove = scanner.nextInt();
                    boolean removed = sms.removeStudent(rollToRemove);
                    if (removed) {
                        System.out.println("Student removed.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter roll number of student to search: ");
                    int rollToSearch = scanner.nextInt();
                    Student searchedStudent = sms.searchStudent(rollToSearch);
                    if (searchedStudent != null) {
                        System.out.println("Student found:");
                        System.out.println(searchedStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    List<Student> allStudents = sms.getAllStudents();
                    if (allStudents.isEmpty()) {
                        System.out.println("No students to display.");
                    } else {
                        System.out.println("All Students:");
                        for (Student student : allStudents) {
                            System.out.println(student);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }
}
