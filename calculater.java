import java.util.*;

public class calculater {
    public static class calculation {
        void all() {
            Scanner sc = new Scanner(System.in);
            System.out.print("\nEnter First no : ");
            int x = sc.nextInt();

            System.out.print("Enter Secound no : ");
            int y = sc.nextInt();
            int z;

            System.out.print("Enter what you want to do (+,-,*,/) : ");
            String c = sc.next();

          try{
          
            switch (c) {
                case "+":
                    z = x + y;
                    System.out.print("Your Solution of " + (x) + " + " + (y) + " = ");
                    System.out.print(z);
                    break;

                case "-":
                    z = x - y;
                    System.out.print("Your Solution of " + (x) + " - " + (y) + " = ");
                    System.out.print(z);
                    break;

                case "*":
                    z = x * y;
                    System.out.print("Your Solution of " + (x) + " * " + (y) + " = ");
                    System.out.print(z);
                    break;

                case "/":
                    z = x / y;
                    System.out.print("Your Solution of " + (x) + " / " + (y) + " = ");
                    System.out.print(z);
                    break;

                default:
                    System.out.println("Error: Invalid operator! Please use +, -, *, or /.");

            }
        }
         catch(Exception e){
             System.out.print ("invalid input at y :Because somthing is divided by 0 is = infinity) ");
          }
        }
    }

    public static void main(String args[]) {
        calculation cl = new calculation();
        int x = 5;
        for (int i = 0; i <= 5; i++) {
            cl.all();
            System.out.println("\n");
        }

    }
}
