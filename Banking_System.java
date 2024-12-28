import java.util.*;
import java.io.*;

public class Banking_System {
    Scanner sc = new Scanner(System.in);

    void creat_acc() {
        // file creation
        int acc_number, balance;
        String name;
        System.out.print("\nEnter account number: ");
        acc_number = sc.nextInt();
        File f = new File("C:\\Users\\vicke\\Desktop\\Banking_system\\" + acc_number + ".txt");
        try {
            f.createNewFile();
        } catch (Exception e) {
            System.out.print("--> file is not created there is somthing wrong <-");
        }
        try {
            FileWriter fw = new FileWriter("C:\\Users\\vicke\\Desktop\\Banking_system\\" + acc_number + ".txt");
            try {
                // fw.write("Account number : "+acc_number);
                System.out.print("Enter account holder name: ");
                name = sc.next();
                fw.write("account holder name : " +name);
                System.out.print("Enter initial balance: ");
                balance = sc.nextInt();
                fw.write("\nbalance :"+balance );
                System.out.println("\n--> Congrats! Your Account has been created <--");
            } finally {
                fw.close();
            }
        } catch (Exception r) {
            System.out.print(r);
        }
    }
    public static boolean containsNumber(String str) {
        return str != null && str.matches(".*\\d.*");
    }    

void deposit() {
     //  arry   variable    obj                  exect location            sari file ko arry of file obj form main list karne ke liye
     File[] B_S_F = new File("C:\\Users\\vicke\\Desktop\\Banking_system").listFiles();
     // har file arry ka ek element hai

    System.out.print("\nEnter Account number: ");
    String an = sc.nextLine();

    if (B_S_F != null) {                                           //B_S_F   = banking system ka folder
        boolean found = false;
        for (int i = 0; i < B_S_F.length; i++) {                   // (B_S_F.length) folder ki length (size)
            File final_file = B_S_F[i];                            //final file variable bsf ke andar jo user input se math kar rahi hai bo file
            if (final_file.getName().equals(an+".txt")) {        //  + ".txt"  (ye jaruri hai because humari file 219.txt karke save hoti hai)
                found = true;
                try (BufferedReader br = new BufferedReader(new FileReader(final_file))) {
                    String data;
                    int currentBalance = 0;
                    String name = "";
    
                    while ((data = br.readLine()) != null) {
                        if (data.startsWith("balance :")) {
                            currentBalance = Integer.parseInt(data.split(":")[1].trim());
                        } else if (data.startsWith("account holder name : ")) {
                            name = data.split(":")[1].trim();
                        }
                    }
                     System.out.print("Enter deposit amount: ");
                     int amount = sc.nextInt();
                     sc.nextLine(); 

                    if (amount > 0) {
                        int finalBalance = currentBalance + amount;
    
                        try (FileWriter fw = new FileWriter(final_file)) {
                            fw.write("account holder name : " + name + "\n");
                            fw.write("balance : " + finalBalance + "\n");
                        }
    
                         catch (Exception e) {
                         System.out.println("Error writing deposite file."+ e);
                        }
                      System.out.println("--> Deposit successful <--");
                    }
                     else {
                     System.out.println("Invalid deposit amount.");
                    }
                }
                 catch (IOException e) {
                 System.out.println("Error reading  deposite file. "+ e);
                }      
            }    
        }
        if(!found){
            System.out.println("Account not found.");
        }
    }
     else {
     System.out.println("Folder empty hai");
    }
}


    void withdraw() {
     //  arry   variable    obj                  exect location            sari file ko arry of file obj form main list karne ke liye
     File[] B_S_F = new File("C:\\Users\\vicke\\Desktop\\Banking_system").listFiles();
     // har file arry ka ek element hai

        System.out.print("\nEnter Account number: ");
        String an = sc.nextLine();
    
        if (B_S_F != null) {                                           
            boolean found = false;
            for (int i = 0; i < B_S_F.length; i++) {                 
                File final_file = B_S_F[i];                            
                if (final_file.getName().equals(an+".txt")) {        
                    found = true;
                    try (BufferedReader br = new BufferedReader(new FileReader(final_file))) {
                        String data;
                        int currentBalance = 0;
                        String name = "";
        
                        while ((data = br.readLine()) != null) {
                            if (data.startsWith("balance :")) {
                                currentBalance = Integer.parseInt(data.split(":")[1].trim());
                            } else if (data.startsWith("account holder name : ")) {
                                name = data.split(":")[1].trim();
                            }
                        }
        
                         System.out.print("Enter withdraw amount: ");
                         int amount = sc.nextInt();
                         sc.nextLine(); 
        
    
                        if (amount > 0) {
                            int finalBalance = currentBalance - amount;
        
                            try (FileWriter fw = new FileWriter(final_file)) {
                                fw.write("account holder name : " + name + "\n");
                                fw.write("balance : " + finalBalance + "\n");
                            }
        
                             catch (Exception e) {
                             System.out.println("Error writing deposite file."+ e);
                            }
                        System.out.println("--> Withdraw successful <--");
                        }
                        else {
                        System.out.println("Invalid Withdraw amount.");
                        }
                    }
                     catch (IOException e) {
                     System.out.println("Error reading  deposite file. "+ e);
                    }
                }
            }  
            if(!found){
                System.out.println("Account not found.");
            }
        } else {
            System.out.println("Folder empty hai");
        }
    }

void check_balances() {
     //  arry   variable    obj                  exect location            sari file ko arry of file obj form main list karne ke liye
     File[] B_S_F = new File("C:\\Users\\vicke\\Desktop\\Banking_system").listFiles();
     // har file arry ka ek element hai

    System.out.print("\nEnter Account number: ");
    int an = sc.nextInt();

     if (B_S_F != null) {                                           
         boolean found = false;
        for (int i = 0; i < B_S_F.length; i++) {                  
            File final_file = B_S_F[i];                           
            if (final_file.getName().equals(an + ".txt")) {       
                found = true;
                try {
                    FileReader fr = new FileReader(final_file);
                    try {
                        int data;
                         while ((data = fr.read()) != -1) {
                            System.out.print((char) data);
                        }
                    }
                     finally {
                     fr.close();
                    }
                }
                 catch (Exception e) {
                 System.out.println("Error reading file.");
                }
            }        
        }
        if(!found) {
            System.out.println("Account not found.");
        }
    }
     else {
     System.out.println("Folder empty hai");
    }
}

    public static void main(String arg[]) {
        Banking_System bs = new Banking_System();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n <<<<<-- WELCOME TO SBI Bank -->>>>> ");
        int i;
        do {

            System.out.print("\n1. for creat new account ");
            System.out.print("\n2. for deposit ");
            System.out.print("\n3. for withdraw ");
            System.out.print("\n4. check_balances ");
            System.out.print("\n5. for << Exit >> ");
            System.out.print("\nEnter your choise : ");
            i = sc.nextInt();

            switch (i) {
                case 1:bs.creat_acc(); break;
                case 2:bs.deposit(); break;
                case 3:bs.withdraw(); break;
                case 4:bs.check_balances(); break;
                case 5:System.out.println("!!!....PROCESS CLOSED....!!! ");break;
                default:System.out.println("\n ~~! Invelid Input !~~ ");
                  
            }
        } while (i != 5);
    }
}
