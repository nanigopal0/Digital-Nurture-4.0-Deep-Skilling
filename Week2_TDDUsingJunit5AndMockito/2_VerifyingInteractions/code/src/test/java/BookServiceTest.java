import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BookServiceTest {
    private static AuthorService authorService;
    private static BookService bookService;

    @BeforeAll
    public static void init(){
        authorService = Mockito.mock(AuthorService.class);
        Author einstein = new Author("Albert Einstein", 20);
        Author hawking = new Author("Stephen Hawking", 15);
        Mockito.when(authorService.getAuthor("Albert Einstein")).thenReturn(einstein);
        Mockito.when(authorService.getAuthor("Stephen Hawking")).thenReturn(hawking);
        bookService = new BookService(authorService);
        bookService.initialBooks();
    }

    @Test
    public void getBookTest() {

        Book book = bookService.getRandomBook("Albert Einstein");

        Assertions.assertEquals(authorService.getAuthor("Albert Einstein"), book.getAuthor());
        Mockito.verify(authorService,Mockito.atLeast(1)).getAuthor("Albert Einstein");
        Mockito.verify(authorService,Mockito.atMost(4)).getAuthor("Stephen Hawking");

    }


}
