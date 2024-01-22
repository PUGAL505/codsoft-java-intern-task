import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Take marks obtained in each subject
        System.out.println("Enter marks obtained in each subject (out of 100):");

        int totalSubjects;
        do {
            System.out.print("Enter the total number of subjects: ");
            totalSubjects = scanner.nextInt();
        } while (totalSubjects <= 0);

        int[] marks = new int[totalSubjects];
        int totalMarks = 0;

        for (int i = 0; i < totalSubjects; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();

            // Validate marks to be between 0 and 100
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks. Marks should be between 0 and 100. Please try again.");
                i--; // Retry the current subject
            } else {
                totalMarks += marks[i];
            }
        }

        // Calculate Total Marks
        System.out.println("\nTotal Marks: " + totalMarks);

        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / totalSubjects;
        System.out.println("Average Percentage: " + averagePercentage + "%");

        // Grade Calculation
        char grade = calculateGrade(averagePercentage);

        // Display Results
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    // Grade Calculation Method
    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
