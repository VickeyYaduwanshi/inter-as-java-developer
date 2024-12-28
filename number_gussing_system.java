import java.util.*;
import java.util.Random;

public class number_gussing_system {

    public static class Game {
        Scanner sc = new Scanner(System.in);
        int num;
        int x;

        Game() {
            Random random = new Random();
            num = random.nextInt(100);
        }

        void check() {
            int count=0;
            System.out.println("\nGuess the number between 0 and 100 : ");
            System.out.print("\n Enter num for guessing : ");
            while (x != num) {
               
                x = sc.nextInt();

                if (x > num) {
                    System.out.println("\nYour guess is too high!");
                    System.out.print("Again Enter num for guessing : ");
                } else if (x < num) {
                    System.out.println("\nYour guess is too low!");
                    System.out.print("Again Enter num for guessing : ");
                }
                count++;
            } 

            System.out.println("\nCongratulations! " + x + " is the correct number!");
            System.out.println("You tried " +"["+(count)+"]"+ " times");
        }
    }

    public static void main(String arg[]) {

        Game G = new Game();

        G.check();

    }
}
