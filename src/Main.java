import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        int rollOne = 0;
        int rollTwo = 0;
        int sum = 0;
        int point = 0;
        String cont = "";
        boolean done = false;
        boolean fin = false;

        do
        {
            System.out.println("Rolling the dice...");
            rollOne = rnd.nextInt(6) + 1;
            rollTwo = rnd.nextInt(6) + 1;
            sum = rollOne + rollTwo;
            System.out.println("You rolled a " + sum);
            if (sum == 2 || sum == 3 || sum == 12)
            {
                System.out.println("Craps! Better luck next time...");
                fin = true;
            }
            else if(sum == 7 || sum == 11)
            {
                System.out.println("Natural! Congrats on winning!");
                fin = true;
            }
            else
            {
                point = sum;
                System.out.println(point + " is now the point!");
            }
            if(point != 0)
            {
                for(int i = 0; i<= 1; i++) {
                    rollOne = rnd.nextInt(6) + 1;
                    rollTwo = rnd.nextInt(6) + 1;
                    sum = rollOne + rollTwo;
                    System.out.println("You rolled a " + sum);
                    if(sum == 7)
                    {
                        System.out.println("You rolled a 7! That means you lose, better luck next time.");
                        i = 2;
                        fin = true;
                    }
                    else if (sum == point)
                    {
                        System.out.println("You rolled the point! That means you win!");
                        i = 2;
                        fin = true;
                    }
                    i -= 1;
                }
            }
            do {
                System.out.println("Thanks for playing, do you want to go again? [Y/N]");
                if(in.hasNext())
                {
                    cont = in.next();
                    in.nextLine();
                }
                if(cont.equalsIgnoreCase("Y"))
                {
                    System.out.println("You chose to play again!");
                    fin = false;
                }
                else
                {
                    System.out.println("Thanks for playing! Come play again soon!");
                    fin = false;
                    done = true;
                }
            }while(fin);
        }while(!done);
    }
}