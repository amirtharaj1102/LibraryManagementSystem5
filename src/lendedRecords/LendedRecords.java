package lendedRecords;

import book.Book;
import patron.Patron;

public class LendedRecords {

    private String recordId;

    private String lendedDate;

    private String dueDate;

    private String returnDate;

    private Book book;

    private Patron patron;


    public LendedRecords(Book book,Patron patron,String recordId, String lendedDate, String dueDate) {

        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        if (patron == null) {
            throw new IllegalArgumentException("Patron cannot be null");
        }
        if (recordId == null || recordId.isEmpty()) {
            throw new IllegalArgumentException("Record ID cannot be null or empty");
        }
        if (lendedDate == null || lendedDate.isEmpty()) {
            throw new IllegalArgumentException("Lended date cannot be null or empty");
        }
        if (dueDate == null || dueDate.isEmpty()) {
            throw new IllegalArgumentException("Due date cannot be null or empty");
        }
        // Constructor implementation
        this.recordId = recordId;
        this.lendedDate = lendedDate;
        this.dueDate = dueDate;
        this.book = book;
        this.patron = patron;
    }

    public void setReturnDate(String returnDate) {
        if (returnDate == null || returnDate.isEmpty()) {
            throw new IllegalArgumentException("Return date cannot be null or empty");
        }
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public String getRecordId() {
        return recordId;
    }
}
