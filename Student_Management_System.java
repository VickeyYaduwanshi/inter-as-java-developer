import java.util.*;

public class Student_Management_System {
    public static class student {
        String name;
        int roll_no, math_mark, physics_mark, chemistry_mark, x;

        void get() {
            Scanner sc = new Scanner(System.in);
            System.out.print("\nEnter name : ");
            name = sc.nextLine();
            System.out.print("Enter Roll no. : ");
            roll_no = sc.nextInt();
            System.out.print("Enter Math marks out of 100 : ");
            math_mark = sc.nextInt();
            System.out.print("Enter physics marks out of 100 : ");
            physics_mark = sc.nextInt();
            System.out.print("Enter chemistry marks out of 100 : ");
            chemistry_mark = sc.nextInt();
        }

        void display() {
            System.out.print("\n total marks : " + (math_mark + physics_mark + chemistry_mark));
            x = (math_mark + physics_mark + chemistry_mark) / 3;
            System.out.print("\n Average marks : " + (x));
            if (x > 80 && x < 100) {
                System.out.print("\n Grade : (A)  to " + (name) + "\n");
            } else if (x > 60 && x < 80) {
                System.out.print("\n Grade : (B) to " + (name) + "\n");
            } else {
                System.out.print("\n Grade : (C) to " + (name) + "\n");
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        student[] s = new student[10];
        System.out.print("enter the number of student : ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            s[i] = new student();
            System.out.print("\nEnter data of students : " + (i));
            s[i].get();
        }
        for (int i = 1; i <= n; i++) {
            System.out.print("\nData of student : " + (s[i].name));
            s[i].display();

        }
    }
}