import java.io.*;
import java.util.List;

public class LibrarySerializer {

    public void saveLibrary(List<Book> books, String file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Book> loadLibrary(String file) {
        File f = new File(file);
        if (!f.exists() || f.length() == 0) return null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Book>) ois.readObject();
        } catch (EOFException e) {
            System.err.println("The file is empty or corrupted: " + file);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
