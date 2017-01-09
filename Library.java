public class Library{
  private String name;
  private Book[] books;

  public Library(String name){
    this.name = name;
    books = new Book[10];
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
    if(isFull()) return;
    books[bookCount()] = book;
  }

  public boolean isFull(){
    return bookCount() == books.length;
  }

  public void rentBook(Book book, Renter renter){
    for(int i = 0; i < bookCount(); i++){
      if(books[i] == book){
        books[i] = null;
        renter.addBook( book );
        return;
      }
    }
  }
}
