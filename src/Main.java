import java.util.List;

import book.Book;
import book.Book.BookBuilder;
import lendedRecords.LendedRecords;
import library.Library;
import patron.Patron;
import service.ILendigService;
import service.LendingService;
import service.StandardLendingPeriod;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ILendigService lendingService= new LendingService(new StandardLendingPeriod(30));// Initialize with an appropriate LendingService instanc
        Library library= new Library(lendingService);
        Book book1 = new Book.BookBuilder()
    .setTitle("The Great Gatsby")
    .setAuthor("F. Scott Fitzgerald")
    .setIsbn("9780743273565")
    .setPublicationYear(1925)
    .setGenre("Fiction")
    .build();

      Book book2 = new Book.BookBuilder()
    .setTitle("To Kill a Mockingbird")
    .setAuthor("Harper Lee")
    .setIsbn("9976632010")
    .setPublicationYear(1960)
    .setGenre("Fiction")
    .build();
        
        // Add books to library
        library.addBook(book1);
        library.addBook(book2);
        System.out.println("Added 2 books to library");
        
        // Create patrons
        Patron patron1 = new Patron("Amir Khan", "P001", "amir@gmail.com", "1234567890");
        Patron patron2 = new Patron("Sara Ali", "P002", "sara@gmail.com", "0987654321");  // FIX: Different patron
        library.addPatron(patron1);
        library.addPatron(patron2);
        System.out.println("Added 2 patrons\n");
        
        // Display available books
        System.out.println("=== Available Books ===");
        List<Book> available = library.availableBooks();
        available.forEach(book -> System.out.println("- " + book.getTitle()));
        System.out.println();
        
        // Borrow book
        System.out.println("=== Borrowing Book ===");
        LendedRecords record = library.borrowBook(book1, patron1);
        if (record != null) {
            System.out.println(patron1.getName() + " borrowed: " + book1.getTitle());
        }
        System.out.println();
        
        // Display borrowed books
        System.out.println("=== Currently Borrowed Books ===");
        List<Book> borrowed = library.borrowedBooks();
        borrowed.forEach(book -> System.out.println("- " + book.getTitle()));
        System.out.println();
        
        // Display available books after borrowing
        System.out.println("=== Available Books After Borrowing ===");
        available = library.availableBooks();
        available.forEach(book -> System.out.println("- " + book.getTitle()));
        System.out.println();
        
        // Return book
        System.out.println("=== Returning Book ===");
        library.returnBook(book1, patron1, record);
        System.out.println(patron1.getName() + " returned: " + book1.getTitle());
        System.out.println();
        
        // Display available books after return
        System.out.println("=== Available Books After Return ===");
        available = library.availableBooks();
        available.forEach(book -> System.out.println("- " + book.getTitle()));


    }
}