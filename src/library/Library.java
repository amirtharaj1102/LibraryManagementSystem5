package library;

import book.Book;
import book.BookInventory;
import lendedRecords.LendedRecords;
import lendedRecords.LendingRecordRepository;
import patron.Patron;
import patron.PatronRepository;
import service.ILendigService;

import java.util.List;

public class Library implements ILibrary {

    private BookInventory bookInventory;
    private PatronRepository patronRepository;
    private ILendigService lendingService;
    private LendingRecordRepository recordRepository;

    public Library(ILendigService lendingService) {
        this.lendingService = lendingService;
        this.bookInventory = new BookInventory();
        this.patronRepository = new PatronRepository();
        this.recordRepository = new LendingRecordRepository();
    }

    @Override
    public Book addBook(Book book) {
        this.bookInventory.addBook(book);
        return book;
    }

    @Override
    public Book removeBook(String isbn) {
        return this.bookInventory.removeBook(isbn);
    }

    public Patron addPatron(Patron patron) {
        this.patronRepository.addPatron(patron);
        return patron;
    }

    public LendedRecords borrowBook(Book book, Patron patron) {
        LendedRecords record = lendingService.borrowBook(book, patron);
        if (record != null) {
            this.recordRepository.addRecord(record);
        }
        return record;
    }

    public void returnBook(Book book, Patron patron, LendedRecords records) {
        lendingService.returnBook(book, patron, records);
        this.recordRepository.removeRecord(records);
    }

    public List<Book> availableBooks() {
        return this.bookInventory.getAvailableBooks();
    }

    public List<Book> borrowedBooks() {
        return this.recordRepository.getBorrowedBooks();
    }
}