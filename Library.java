import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void loadBooks(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String title  = parts[0].trim();
                    String author = parts[1].trim();
                    int year      = Integer.parseInt(parts[2].trim());
                    books.add(new Book(title, author, year));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewAllBooks() {
        books.forEach(System.out::println);
    }

    public Book searchBookByKeyword(String keyword) {
        keyword = keyword.toLowerCase();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword) ||
                    b.getAuthor().toLowerCase().contains(keyword) ||
                    String.valueOf(b.getPublicationYear()).equals(keyword)) {
                return b;
            }
        }
        return null;
    }

    public List<Book> getBooks()           { return books; }
    public void      setBooks(List<Book> l){ books = l;    }
}
