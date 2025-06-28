import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BookServiceTest {

    @Test
    public void getBookTest() {
        AuthorService authorService = Mockito.mock(AuthorService.class);
        Author einstein = new Author("Albert Einstein", 20);
        Author hawking = new Author("Stephen Hawking", 15);
        Mockito.when(authorService.getAuthor("Albert Einstein")).thenReturn(einstein);
        Mockito.when(authorService.getAuthor("Stephen Hawking")).thenReturn(hawking);

        BookService bookService = new BookService(authorService);
        bookService.initialBooks();
        Book book = bookService.getRandomBook("Albert Einstein");

        Assertions.assertEquals(einstein, book.getAuthor());
    }


}
