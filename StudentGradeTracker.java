
import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Double> studentGrades = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a valid number of students.");
            sc.close();
            return;
        }

        // Input student details
        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Enter student name: ");
            String name = sc.next();

            System.out.print("Enter grade: ");
            double grade = sc.nextDouble();

            studentNames.add(name);
            studentGrades.add(grade);
        }

        // Calculate average, highest and lowest
        double sum = 0;
        double highest = studentGrades.get(0);
        double lowest = studentGrades.get(0);

        for (double grade : studentGrades) {

            sum += grade;

            if (grade > highest) {
                highest = grade;
            }

            if (grade < lowest) {
                lowest = grade;
            }
        }

        double average = sum / n;

        // Display report
        System.out.println("\n=================================");
        System.out.println("    STUDENT GRADE REPORT");
        System.out.println("=================================");

        System.out.printf("%-15s %-10s%n", "Student", "Grade");
        System.out.println("---------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-15s %-10.2f%n",
                    studentNames.get(i),
                    studentGrades.get(i));
        }

        System.out.println("---------------------------------");
        System.out.printf("Average Grade : %.2f%n", average);
        System.out.printf("Highest Grade : %.2f%n", highest);
        System.out.printf("Lowest Grade : %.2f%n", lowest);

        System.out.println("=================================");

        sc.close();
    }
}

