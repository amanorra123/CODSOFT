import java.util.Scanner;
        import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int gssnum;
        int chance = 10;
        int min = 1;
        int max = 100;
        int srtnum = random.nextInt(max - min + 1) + min;

        System.out.println("I have decided a number as a secret number and you have to guess it now. Range is 1 to 100");
        System.out.println("You have only 10 chances");

        for (; chance > 0; chance--) {
            System.out.print("Guess the number: ");
            gssnum = scanner.nextInt();

            if (srtnum == gssnum) {
                System.out.println("Correct");
                break;
            } else if (gssnum > srtnum) {
                System.out.println("You guessed higher, secret number is lower than you guessed");
                System.out.println("Chances left: " + (chance - 1));
            } else if (gssnum < srtnum) {
                System.out.println("You guessed lower, secret number is higher than you guessed");
                System.out.println("Chances left: " + (chance - 1));
            }
        }

        if (chance == 0) {
            System.out.println("You failed to guess the right number.");
        } else {
            System.out.println("Congratulations, you guessed the number successfully.");
        }
    }
}

