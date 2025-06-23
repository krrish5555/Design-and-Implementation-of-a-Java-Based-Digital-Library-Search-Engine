import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortUtil {

    public static void bubbleSort(List<Book> books, Comparator<Book> c) {
        int n = books.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (c.compare(books.get(j), books.get(j + 1)) > 0) {
                    Collections.swap(books, j, j + 1);
                }
            }
        }
    }

    public static void insertionSort(List<Book> books, Comparator<Book> c) {
        for (int i = 1; i < books.size(); i++) {
            Book key = books.get(i);
            int j = i - 1;
            while (j >= 0 && c.compare(books.get(j), key) > 0) {
                books.set(j + 1, books.get(j));
                j--;
            }
            books.set(j + 1, key);
        }
    }

    public static void quickSort(List<Book> books, Comparator<Book> c, int low, int high) {
        if (low < high) {
            int pi = partition(books, c, low, high);
            quickSort(books, c, low, pi - 1);
            quickSort(books, c, pi + 1, high);
        }
    }

    private static int partition(List<Book> books, Comparator<Book> c, int low, int high) {
        Book pivot = books.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (c.compare(books.get(j), pivot) <= 0) {
                i++;
                Collections.swap(books, i, j);
            }
        }
        Collections.swap(books, i + 1, high);
        return i + 1;
    }
}
