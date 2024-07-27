import java.util.Random;
import java.util.Scanner;

public class NumberGame{
    private static final int MAX_ATTEMPTS = 4;
    private static final int MAX_ROUNDS = 5;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static int score = 0;
    private static int round = 1;
    private static Scanner sc = new Scanner(System.in);
    private static Random rd = new Random();

    public static void main(String[] args) {
        while (round <= MAX_ROUNDS) {
            int numberToGuess = generateRandomNumber(MIN_NUMBER, MAX_NUMBER);
            int attempts = 0;
            boolean correctGuess = false;

            System.out.println("Round " + round + " of " + MAX_ROUNDS);
            System.out.println("Only have " + MAX_ATTEMPTS + " attempts.");

            while (attempts < MAX_ATTEMPTS) {
                System.out.println("Enter your guess (From " + MIN_NUMBER + " to " + MAX_NUMBER + "):");
                int guess = sc.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You Win! You guessed the number in " + attempts + " attempt.");
                    score++;
                    correctGuess = true;
                    break;
                }
            }

            if (!correctGuess) {
                System.out.println("Sorry, you guessed it wrong. The number was " + numberToGuess + ".");
            }

            round++;
            System.out.println("Your current score is " + score + " out of " + (round - 1) + ".");
            System.out.println("Wanna play the next round? ( Hell Yeah!! or No I'm Tired)");
            String userInput = sc.next();

            if (userInput.equalsIgnoreCase("no")) {
                break;
            }
        }

        System.out.println("Game Over! Your final score is " + score + " out of " + (round - 1) + ".");
    }

    private static int generateRandomNumber(int min, int max) {
        return rd.nextInt(max - min + 1) + min;
    }
}