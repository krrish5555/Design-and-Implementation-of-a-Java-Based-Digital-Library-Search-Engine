import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private Library library;
    private final UserInteractionLogger logger = new UserInteractionLogger();
    private final LibrarySerializer serializer = new LibrarySerializer();

    public LibraryMenu(Library library) {
        this.library = library;
        List<Book> saved = serializer.loadLibrary("src/resources/data/library.ser");
        if (saved != null) {
            library.setBooks(saved);
            System.out.println("Library loaded successfully.");
        } else {
            System.out.println("No saved library found. Loading default books.");
            library.loadBooks("src/resources/data/books.txt");
        }
    }

    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    === Main Menu ===
                    1. View All Books
                    2. Sort Books by Title
                    3. Sort Books by Author
                    4. Sort Books by Year
                    5. Search for a Book by keyword
                    6. Exit""");
            System.out.print("Choice: ");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1" -> {
                    library.viewAllBooks();
                    logger.logViewAllBooks();
                }
                case "2" -> {
                    SortUtil.bubbleSort(library.getBooks(), Comparator.comparing(Book::getTitle));
                    library.viewAllBooks();
                    logger.logSort("title (bubble sort)");
                }
                case "3" -> {
                    SortUtil.insertionSort(library.getBooks(), Comparator.comparing(Book::getAuthor));
                    library.viewAllBooks();
                    logger.logSort("author (insertion sort)");
                }
                case "4" -> {
                    List<Book> list = library.getBooks();
                    SortUtil.quickSort(list, Comparator.comparingInt(Book::getPublicationYear), 0, list.size() - 1);
                    library.viewAllBooks();
                    logger.logSort("year (quick sort)");
                }
                case "5" -> {
                    System.out.print("Enter keyword: ");
                    String kw = sc.nextLine();
                    Book b = library.searchBookByKeyword(kw);
                    if (b != null) System.out.println("Book found: " + b);
                    else System.out.println("Book not found.");
                    logger.logSearch(kw);
                }
                case "6" -> {
                    serializer.saveLibrary(library.getBooks(), "src/resources/data/library.ser");
                    System.out.println("Library saved. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
