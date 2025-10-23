package libmansys;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Show Books");
            System.out.println("4. Show Users");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Select option: ");
            int opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1:
                    System.out.print("Book ID: ");
                    int bid = sc.nextInt(); sc.nextLine();
                    System.out.print("Book Title: ");
                    String btitle = sc.nextLine();
                    System.out.print("Book Author: ");
                    String bauthor = sc.nextLine();
                    library.addBook(new Book(bid, btitle, bauthor));
                    break;
                case 2:
                    System.out.print("User ID: ");
                    int uid = sc.nextInt(); sc.nextLine();
                    System.out.print("User Name: ");
                    String uname = sc.nextLine();
                    library.addUser(new User(uid, uname));
                    break;
                case 3:
                    library.showBooks();
                    break;
                case 4:
                    library.showUsers();
                    break;
                case 5:
                    System.out.print("Book ID to issue: ");
                    bid = sc.nextInt();
                    System.out.print("User ID to issue to: ");
                    uid = sc.nextInt(); sc.nextLine();
                    library.issueBook(bid, uid);
                    break;
                case 6:
                    System.out.print("Book ID to return: ");
                    bid = sc.nextInt(); sc.nextLine();
                    library.returnBook(bid);
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting Library System.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
