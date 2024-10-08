import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;

            while (true) {
                System.out.print("Guess the number between 1 and 100: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    System.out.printf("Congratulations! You guessed the correct number %d in %d attempts.%n", secretNumber, attempts);
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempts == 8) {
                    System.out.println("Sorry, you've used all your attempts. The correct number was " + secretNumber);
                    break;
                }
            }

            System.out.print("Do you want to play again?(Yes/No): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("Yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
