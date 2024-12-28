import java.util.*;

public class Library_Management_System {
    public static class library_system {
        
        ArrayList<String> book_names = new ArrayList<>();
        ArrayList<String> book_author = new ArrayList<>();
        ArrayList<Boolean> book_issued = new ArrayList<>();
        String book_name, author ,  status;;
        Scanner sc = new Scanner(System.in);

        void Add() {
            System.out.print("Enter book name: ");
            book_name = sc.nextLine();
            book_names.add(book_name);
            System.out.print("Enter author of the book: ");
            author = sc.nextLine();
            book_author.add(author);
     book_issued.add(false);                                       // By default, book is not issued
            System.out.println("Added Book: " + book_name);
        }

        void Issue() {
            System.out.print("Enter the name of the book to issue: ");
            String search = sc.nextLine();                                 //search ke liye book name input le raha hai
            boolean found = false;

            for (int i = 0; i < book_names.size(); i++) {
                if (!book_issued.get(i)) {                                  //!book_issued.get(i) ye line line 18 ke false ko true kar rahi hai
                    System.out.println("Your book \"" + book_names.get(i) + "\" is issued.");
                    book_issued.set(i, true);                         // Mark as issued
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Book not found or already issued.");
            }
        }

        void Search() {
            System.out.print("Enter the name of the book to search: ");
            String search = sc.nextLine();
            boolean found = false;

            for (int i = 0; i < book_names.size(); i++) {
                if (search.equalsIgnoreCase(book_names.get(i))) {
                    if (book_issued.get(i)) {
                        status = "Issued";
                   } else {
                        status = "Available";
                   }
                    System.out.println("Book \"" + book_names.get(i) + "\" found at index [" + (i + 1) + "], Author: " + book_author.get(i) + ", Status: " + status);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Book not found.");
            }
        }

        void View() {
            System.out.println("Viewing Books:");
            for (int i = 0; i < book_names.size(); i++) {
        if (book_issued.get(i)) {
             status = "Issued";
        } else {
             status = "Available";
        }
                System.out.println((i + 1) + ". Book: " + book_names.get(i) + ", Author: " + book_author.get(i) + ", Status: " + status);
            }
        }

      
        void Return() {
            System.out.print("Enter the name of the book to return: ");
            String search = sc.nextLine();
            boolean found = false;

            for (int i = 0; i < book_names.size(); i++) {
                if ( book_issued.get(i)) {
                    System.out.println("Your book \"" + book_names.get(i) + "\" is returned.");
                    book_issued.set(i, false); // Mark as not issued
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Book not found or not issued.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        library_system ls = new library_system();
        String x;

        do {
            System.out.println("\n1. Add book");
            System.out.println("2. View Books");
            System.out.println("3. Search Books");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            x = sc.next();

            switch (x.toLowerCase()) {
                case "add": ls.Add(); break;
                case "view": ls.View(); break;
                case "search":ls.Search(); break;
                case "issue": ls.Issue();break;
                case "return":ls.Return(); break;
                case "exit":System.out.println("Exiting..."); break;
                default:  System.out.println("Invalid choice. Please try again.");            
            }
        } while (!x.equalsIgnoreCase("exit"));
        sc.close();
    }
}
