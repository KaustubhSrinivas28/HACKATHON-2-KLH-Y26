import java.util.Scanner;

class Student {
    String studentName;
    String rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    Student(String studentName, String rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    double calculateFee() {
        return courseCredits * 1500;
    }

    boolean checkEligibility() {
        if (marks >= 50) {
            return true;
        } else {
            return false;
        }
    }

    double calculateScholarship() {
        double fee = calculateFee();
        double scholarship;

        if (marks >= 85) {
            scholarship = fee * 0.20;
        } else if (marks >= 70) {
            scholarship = fee * 0.10;
        } else {
            scholarship = 0;
        }
        return scholarship;
    }

    double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    void displayDetails() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);

        if (checkEligibility()) {
            System.out.println("Eligibility: Eligible");
        } else {
            System.out.println("Eligibility: Not Eligible");
        }

        System.out.println("Total Fee: Rs. " + calculateFee());
        System.out.println("Scholarship: Rs. " + calculateScholarship());
        System.out.println("Final Fee: Rs. " + calculateFinalFee());
    }
}

public class StudentRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        String roll = sc.nextLine();
        double marks = sc.nextDouble();
        sc.nextLine();
        String course = sc.nextLine();
        int credits = sc.nextInt();

        Student s = new Student(name, roll, marks, course, credits);

        if (s.checkEligibility()) {
            s.displayDetails();
        } else {
            System.out.println("Student is not eligible for registration.");
        }

        sc.close();
    }
}