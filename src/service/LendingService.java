package service;

import book.Book;
import lendedRecords.LendedRecords;
import patron.Patron;



import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class LendingService implements ILendigService {


private final LendingPeriodStrategy periodStrategy;
    
    public LendingService(LendingPeriodStrategy periodStrategy) {
        this.periodStrategy = periodStrategy;
    }




    @Override
    public LendedRecords borrowBook(Book book, Patron patron) {

          // FIX: Logic was backwards - should reject if reserved OR unavailable
        if (book.isReserved() || !book.isAvailable()) {
            System.out.println("Book cannot be borrowed: " + 
                (book.isReserved() ? "Reserved" : "Not available"));
            return null;
        }
        
            // Get current date
            Date currentDate = new Date();

String recordId = UUID.randomUUID().toString(); 
            Date dueDate = periodStrategy.calculateDueDate(currentDate);
            LendedRecords lendedRecords = new LendedRecords(book,patron,recordId,currentDate.toString(),dueDate.toString());
            patron.addBorrowedBook(book.getIsbn());
            book.setAvailable(false);
            return lendedRecords;
        
      

    }

    @Override
    public void returnBook(Book book, Patron patron, LendedRecords lendedRecords) {
        Date returnDate = new Date();
        lendedRecords.setReturnDate(returnDate.toString());
        patron.removeBorrowedBook(book.getIsbn());
        patron.addToBorrowHistory(book.getIsbn());
        patron.addPreferredGenre(book.getGenre());
        book.setAvailable(true);

    }
}
