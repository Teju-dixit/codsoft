import java.util.Scanner;
import java.util.Random;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int min = 1, max = 100, attempts = 0;
            int numberToGuess = random.nextInt(max - min + 1) + min;
            int maxAttempts = 10; // Limit to 10 attempts
            boolean isCorrect = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between " + min + " and " + max + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it. Good luck!");

            while (attempts < maxAttempts) {
                attempts++;
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    isCorrect = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!isCorrect) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + numberToGuess);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Goodbye!");
        scanner.close();
    }
}