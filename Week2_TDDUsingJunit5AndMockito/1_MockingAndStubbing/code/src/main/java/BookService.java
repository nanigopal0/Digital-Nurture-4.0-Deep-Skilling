import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookService {

    private List<Book> books;
    private final AuthorService authorService;

    public BookService(AuthorService authorService) {
        this.books = new ArrayList<>();
        this.authorService = authorService;
    }

    public Book getBook(String bookName) {
        return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(bookName)).toList().getFirst();
    }

    public Book getRandomBook(String authorName) {
        Author author = authorService.getAuthor(authorName);
        List<Book> list = books.stream().filter(book -> book.getAuthor().equals(author)).toList();
        Random random = new Random();
        int randomIndex = random.nextInt(0, list.size());
        return list.get(randomIndex);
    }

    public void initialBooks() {
        books.add(new Book("Relativity: The Special and the General Theory", authorService.getAuthor("Albert Einstein"), 2698));
        books.add(new Book("The Evolution of Physics", authorService.getAuthor("Albert Einstein"), 1325));
        books.add(new Book("A Brief History of Time", authorService.getAuthor("Stephen Hawking"), 2450));
        books.add(new Book("The Universe in a Nutshell ", authorService.getAuthor("Stephen Hawking"), 1450));
        books.add(new Book("Black Holes and Baby Universes and Other Essays", authorService.getAuthor("Stephen Hawking"), 3450));
    }
}
