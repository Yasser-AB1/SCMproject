import java.util.Scanner;

public class GradeCalculator {

    public static double calculateAverage(double[] scores) {
        double sum = 0;
        for (double s : scores) sum += s;
        return sum / scores.length;
    }

    public static String getLetterGrade(double avg) {
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }

    public static String getPassFail(double avg) {
        return avg >= 60 ? "PASS" : "FAIL";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("How many subjects? ");
        int count = Integer.parseInt(scanner.nextLine());

        double[] scores = new double[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter score for subject " + (i + 1) + ": ");
            scores[i] = Double.parseDouble(scanner.nextLine());
        }

        double avg = calculateAverage(scores);
        System.out.println("\n--- Results for " + name + " ---");
        System.out.printf("Average Score : %.2f%n", avg);
        System.out.println("Letter Grade  : " + getLetterGrade(avg));
        System.out.println("Status        : " + getPassFail(avg));

        scanner.close();
    }
}