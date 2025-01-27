import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {

    static class Question {
        String questionText;
        String[] options;
        int correctOption;

        public Question(String questionText, String[] options, int correctOption) {
            this.questionText = questionText;
            this.options = options;
            this.correctOption = correctOption;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Store questions and options
        Question[] questions = {
            new Question("What is the capital of France?",
                    new String[]{"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"}, 3),
            new Question("Which planet is known as the Red Planet?",
                    new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Saturn"}, 2),
            new Question("Who wrote 'To Kill a Mockingbird'?",
                    new String[]{"1. Harper Lee", "2. J.K. Rowling", "3. Mark Twain", "4. Jane Austen"}, 1)
        };

        int score = 0;
        int timePerQuestion = 10; // Time in seconds

        // Quiz loop
        for (int i = 0; i < questions.length; i++) {
            Question question = questions[i];
            System.out.println("Question " + (i + 1) + ": " + question.questionText);

            for (String option : question.options) {
                System.out.println(option);
            }

            Timer timer = new Timer();
            boolean[] answered = {false}; // To track if the user answered in time

            // Timer task to end the question if time runs out
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (!answered[0]) {
                        System.out.println("\nTime's up! Moving to the next question.");
                        answered[0] = true;
                    }
                }
            }, timePerQuestion * 1000);

            System.out.print("Your answer: ");
            int userAnswer = -1;

            if (!answered[0]) {
                try {
                    userAnswer = scanner.nextInt();
                    answered[0] = true;
                } catch (Exception e) {
                    System.out.println("Invalid input!");
                    scanner.nextLine(); // Clear the scanner buffer
                }
            }

            timer.cancel(); // Stop the timer

            if (userAnswer == question.correctOption && answered[0]) {
                System.out.println("Correct!");
                score++;
            } else if (answered[0]) {
                System.out.println("Wrong! The correct answer was " + question.correctOption);
            }
            System.out.println();
        }

        // Display result screen
        System.out.println("Quiz Over!");
        System.out.println("Your score: " + score + "/" + questions.length);
    }
}