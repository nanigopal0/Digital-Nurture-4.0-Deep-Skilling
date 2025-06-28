import java.util.ArrayList;
import java.util.List;

public class AuthorService {
    private List<Author> authors;


    public AuthorService() {
        this.authors = new ArrayList<>();
    }

    public void initAuthors() {
        authors.add(new Author("Albert Einstein", 20));
        authors.add(new Author("Stephen Hawking", 15));
    }

    public Author getAuthor(String authorName) {
        return authors.stream().filter(author -> author.getName().equalsIgnoreCase(authorName)).toList().getFirst();
    }


}
