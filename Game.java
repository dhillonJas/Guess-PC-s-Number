import java.util.InputMismatchException;
import java.util.Scanner;

public class Game
{
    private static int number;
    private static int tries;

    public static void main(String[] args) {
        System.out.print("I have thought of a number. Can you guess it if I give you hints?");
        System.out.print("Choose difficulty: \nEasy\tMedium\tHard\n---->");
        number = number();
        while (number == 0)
            number = number();
        guess();
    }

    public static void guess()
    {
        try {
            for (int i = 1; i < tries + 1; i++) {
                if (i == tries)
                    System.out.println("Last try.");
                Scanner sc = new Scanner(System.in);
                int guess = sc.nextInt();
                if (guess > number) {
                    System.out.println("Lower than that.");
                } else if (guess < number) {
                    System.out.println("Greater than that.");
                } else {
                    System.out.println("You guessed the number correctly in " + i + " tries.");
                    break;
                }
                if (i == tries)
                    System.out.println("\nYou lost the game. The number was " + number);
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Not valid.");

        }
    }

    public static String difficulty()
    {
        Scanner sc = new Scanner(System.in);
        String r = sc.next();
        return r;
    }

    public static int number()
    {
        String diff = difficulty();
        if(diff.equalsIgnoreCase("Easy"))
        {
            number = (int)(10*Math.random());
            System.out.println("You chose Easy. You have 5 tries to guess the number between 1 and 10.");
            tries = 5;
        }
        else if(diff.equalsIgnoreCase("Medium"))
        {
            number = (int)(100*Math.random());
            System.out.println("You chose Medium. You have 7 tries to guess the number between 1 and 100.");
            tries = 7;
        }
        else if(diff.equalsIgnoreCase("Hard"))
        {
            number =  (int)(500*Math.random());
            System.out.println("You chose Hard. You have 10 tries to guess the number between 1 and 500.");
            tries = 10;
        }
        else
        {
            System.out.print("Not valid! Try Again.\n--->");
            number = 0;
        }
        return number;
    }
}
