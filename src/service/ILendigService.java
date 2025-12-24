package service;

import book.Book;
import lendedRecords.LendedRecords;
import patron.Patron;

public interface ILendigService {

    LendedRecords borrowBook(Book book, Patron patron);

    void returnBook(Book book, Patron patron, LendedRecords records);
}
