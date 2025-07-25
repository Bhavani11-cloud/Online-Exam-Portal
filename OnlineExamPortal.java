
import java.util.Scanner;

public class OnlineExamPortal {
    static Scanner sc = new Scanner(System.in);
    static String storedUsername = "student";
    static String storedPassword = "1234";
    static int score = 0;

    public static void main(String[] args) {
        System.out.println("==== Welcome to the Online Exam Portal ====");

        if (login()) {
            System.out.println("\nLogin successful!\n");
            mainMenu();
        } else {
            System.out.println("Too many failed attempts. Exiting...");
        }
    }

    // Login function
    public static boolean login() {
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();

            if (username.equals(storedUsername) && password.equals(storedPassword)) {
                return true;
            } else {
                System.out.println("Incorrect credentials. Try again.");
                attempts++;
            }
        }
        return false;
    }

    // Main menu
    public static void mainMenu() {
        while (true) {
            System.out.println("\n===== Main Menu =====");
            System.out.println("1. Start Exam");
            System.out.println("2. View Score");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    startExam();
                    break;
                case 2:
                    System.out.println("Your current score is: " + score + " out of 5");
                    break;
                case 3:
                    System.out.println("Thank you! Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Start the exam
    public static void startExam() {
        score = 0;
        System.out.println("\n=== Exam Started ===");
        String[] questions = {
            "Q1. What is the capital of India?\n a) Delhi\n b) Mumbai\n c) Chennai\n d) Kolkata",
            "Q2. Java is a ____ language?\n a) Low-level\n b) Machine-level\n c) High-level\n d) Binary",
            "Q3. Who invented Java?\n a) Dennis Ritchie\n b) James Gosling\n c) Guido van Rossum\n d) Bjarne Stroustrup",
            "Q4. Which of these is a Java keyword?\n a) function\n b) var\n c) new\n d) def",
            "Q5. Which company owns Java now?\n a) Sun Microsystems\n b) Oracle\n c) Microsoft\n d) Google"
        };

        char[] answers = {'a', 'c', 'b', 'c', 'b'};

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\n" + questions[i]);
            System.out.print("Your answer: ");
            char userAnswer = sc.nextLine().toLowerCase().charAt(0);

            if (userAnswer == answers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: " + answers[i]);
            }
        }

        System.out.println("\n=== Exam Finished ===");
        System.out.println("You scored: " + score + " out of " + questions.length);
    }
}
