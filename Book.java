import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle()            { return title; }
    public void   setTitle(String t)    { title = t;    }
    public String getAuthor()           { return author; }
    public void   setAuthor(String a)   { author = a;   }
    public int    getPublicationYear()  { return publicationYear; }
    public void   setPublicationYear(int y) { publicationYear = y; }

    public String toString() {
        return "Book{title='" + title + "', author='" + author +
                "', publicationYear=" + publicationYear + '}';
    }
}
