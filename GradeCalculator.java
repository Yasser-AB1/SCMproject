import java.util.Scanner;

public class GradeCalculator {

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

        System.out.println("\n--- Results for " + name + " ---");
        System.out.println("Scores entered: " + count + " subjects");
        System.out.println("(Features coming soon...)");

        scanner.close();
    }
}