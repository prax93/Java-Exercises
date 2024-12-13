package LibraryExercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Library {

    public static void main(String[] args) {


        List<LibraryItem> library = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add a Book");
            System.out.println("2. Add a Magazine");
            System.out.println("3. Display All Items");
            System.out.println("4. Search Items by Title");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Book Title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = scanner.nextLine();
                    library.add(new Book(bookTitle, author));
                }
                case 2 -> {
                    System.out.print("Enter Magazine Title: ");
                    String magazineTitle = scanner.nextLine();
                    System.out.print("Enter Issue Number: ");
                    int issueNumber = scanner.nextInt();
                    library.add(new Magazine(magazineTitle, issueNumber));
                }
                case 3 -> {
                    System.out.println("\nLibrary Items:");
                    library.forEach(LibraryItem::displayInfo);
                }
                case 4 -> {
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    List<LibraryItem> results = library.stream().filter(libraryItem -> {
                        return libraryItem.getTitle().equals(searchTitle);
                    }).toList();

                    System.out.println("\nSearch Results:");
                    results.forEach(LibraryItem::displayInfo);
                }
                case 5 -> {
                    System.out.println("Exiting the Library System. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }


        }
    }
}
