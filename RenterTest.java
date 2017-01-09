import static org.junit.Assert.assertEquals;
import org.junit.*;

public class RenterTest{
  Library library;
  Book book;
  Renter renter;

  @Before
  public void before(){
    library = new Library("CodeClan Library");
    book = new Book();
    renter = new Renter("Matthew");

    library.addBook(book);
  }

  @Test
  public void canGetRenterName(){
    assertEquals("Matthew", renter.getName());
  }

  @Test
  public void startsWithNoBooks(){
    assertEquals(0, renter.bookCount());
  }

  @Test
  public void canAddBook(){
    renter.addBook(book);
    assertEquals(1, renter.bookCount());
  }

  @Test
  public void canSeeIfRenting(){
    library.rentBook(book, renter);
    assertEquals(true, renter.isRenting());
  }

  @Test
  public void canOnlyRent1Book(){
    library.rentBook(book, renter);
    library.rentBook(book, renter);
    assertEquals(1, renter.bookCount());
  }
}
