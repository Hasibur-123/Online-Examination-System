import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExaminationSystem examSystem = new ExaminationSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Online Examination System!");

        while (true) {
            System.out.println("\n1. Register Student");
            System.out.println("2. Start Exam");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    examSystem.registerStudent();
                    break;
                case 2:
                    examSystem.startExam();
                    break;
                case 3:
                    System.out.println("Thank you for using the Online Examination System!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
