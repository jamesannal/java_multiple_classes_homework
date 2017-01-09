public class Renter{
  private String name;
  private Book[] books;

  public Renter(String name){
    this.name = name;
    books = new Book[1];
  }

  public String getName(){
    return name;
  }

  public int bookCount(){
    int count = 0;
    for(Book book : books){
      if(book != null) count++;
    }
    return count;
  }

  public void addBook(Book book){
    if(isRenting()) return;
    books[bookCount()] = book;
  }

  public boolean isRenting(){
    return bookCount() == books.length;
  }

  public void returnBook(Library library){
    library.addBook(books[0]);
    books[0] = null;
  }
}
