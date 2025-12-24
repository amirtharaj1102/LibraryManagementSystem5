package library;

import book.Book;
import lendedRecords.LendedRecords;
import patron.Patron;

import java.util.List;

public interface ILibrary {
    Book addBook(Book book);
    Book removeBook(String isbn);
    Patron addPatron(Patron patron);
    LendedRecords borrowBook(Book book, Patron patron);
    void returnBook(Book book, Patron patron, LendedRecords records);
    List<Book> availableBooks();
    List<Book> borrowedBooks();
}