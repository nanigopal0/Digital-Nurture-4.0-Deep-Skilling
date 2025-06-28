import java.util.List;

public class Author {
    private String name;
    private int totalBooks;


    public Author(String name, int totalBooks) {
        this.name = name;

        this.totalBooks = totalBooks;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", totalBooks=" + totalBooks +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getTotalBooks() {
        return totalBooks;
    }

    public void setTotalBooks(int totalBooks) {
        this.totalBooks = totalBooks;
    }
}
