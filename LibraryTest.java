import static org.junit.Assert.assertEquals;
import org.junit.*;

public class LibraryTest{
  Library library;
  Book book;
  Renter renter;

  @Before
  public void before(){
    library = new Library("Inverurie Library");
    book = new Book();
    renter = new Renter("Harrison Booth");
  }

  @Test
  public void hasName(){
    assertEquals("Inverurie Library", library.getName());
  }

  @Test
  public void startsWithNoBooks(){
    assertEquals(0, library.bookCount());
  }

  @Test
  public void canAddBook(){
    library.addBook(book);
    assertEquals(1, library.bookCount());
  }

  @Test
  public void isFullAfter10Books(){
    for(int i = 0; i < 10; i++){
      library.addBook(book);
    }
    assertEquals(true, library.isFull());
  }

  @Test
  public void cannotAddBooksWhenFull(){
    for(int i = 0; i < 20; i++){
      library.addBook(book);
    }
  }

  @Test
  public void canRentBook(){
    library.addBook(book);
    library.rentBook(book, renter);
    assertEquals(1, renter.bookCount());
    assertEquals(0, library.bookCount());
  }
}
