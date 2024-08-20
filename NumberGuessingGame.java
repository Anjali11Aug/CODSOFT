import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();
        
        int minNumber = 1;
        int maxNumber = 100;
        int maxGuesses = 10;
        int totalPoints = 0;
        int gamesPlayed = 0;
        
        while (true) {
            int secretNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            int guessCount = 0;
            boolean won = false;
            
            System.out.println("Game " + (gamesPlayed + 1));
            System.out.println("I'm thinking of a number between " + minNumber + " and " + maxNumber + ".");
            
            while (guessCount < maxGuesses) {
                System.out.print("What's your guess? (Try " + (guessCount + 1) + " of " + maxGuesses + "): ");
                int guess = Integer.parseInt(reader.readLine());
                guessCount++;
                
                if (guess == secretNumber) {
                    System.out.println("You got it! The number was " + secretNumber);
                    won = true;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }
            
            if (!won) {
                System.out.println("Sorry, you used all your guesses. The number was " + secretNumber);
            }
            
            int points = maxGuesses - guessCount;
            if (points < 0) points = 0;
            totalPoints += points;
            gamesPlayed++;
            
            System.out.println("You got " + points + " points this game");
            System.out.println("Your total points: " + totalPoints);
            System.out.println("Games played: " + gamesPlayed);
            
            System.out.print("Want to play again? (yes/no): ");
            String playAgain = reader.readLine();
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        
        System.out.println("Thanks for playing!");
        System.out.println("Final score: " + totalPoints);
        System.out.println("Games played: " + gamesPlayed);
    }
}