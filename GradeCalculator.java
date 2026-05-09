import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class GradeCalculator {

    public static double calculateWeightedAverage(double[] scores, double[] weights) {
        double weightedSum = 0, totalWeight = 0;
        for (int i = 0; i < scores.length; i++) {
            weightedSum += scores[i] * weights[i];
            totalWeight += weights[i];
        }
        return weightedSum / totalWeight;
    }

    // CONFLICT: this branch adds +/- grades; the other branch uses plain A/B/C
    public static String getLetterGrade(double avg) {
        if (avg >= 93) return "A";
        else if (avg >= 90) return "A-";
        else if (avg >= 87) return "B+";
        else if (avg >= 83) return "B";
        else if (avg >= 80) return "B-";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }

    public static void exportResults(String name, double avg, String grade, String status) {
        try (FileWriter fw = new FileWriter(name.replaceAll(" ", "_") + "_results.txt")) {
            fw.write("Student: " + name + "\n");
            fw.write("Weighted Average: " + String.format("%.2f", avg) + "\n");
            fw.write("Grade: " + grade + "\n");
            fw.write("Status: " + status + "\n");
            System.out.println("Results exported to file.");
        } catch (IOException e) {
            System.out.println("Export failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("How many subjects? ");
        int count = Integer.parseInt(scanner.nextLine());

        double[] scores = new double[count];
        double[] weights = new double[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Subject " + (i + 1) + " score: ");
            scores[i] = Double.parseDouble(scanner.nextLine());
            System.out.print("Subject " + (i + 1) + " weight (%): ");
            weights[i] = Double.parseDouble(scanner.nextLine());
        }

        double avg = calculateWeightedAverage(scores, weights);
        String grade = getLetterGrade(avg);
        String status = avg >= 60 ? "PASS" : "FAIL";

        System.out.println("\n--- Results for " + name + " ---");
        System.out.printf("Weighted Average : %.2f%n", avg);
        System.out.println("Letter Grade     : " + grade);
        System.out.println("Status           : " + status);

        System.out.print("\nExport results to file? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            exportResults(name, avg, grade, status);
        }

        scanner.close();
    }
}