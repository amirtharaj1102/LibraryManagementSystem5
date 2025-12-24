package lendedRecords;

import book.Book;
import java.util.ArrayList;
import java.util.List;

public class LendingRecordRepository {
    private List<LendedRecords> records = new ArrayList<>();
    
    public void addRecord(LendedRecords record) {
        records.add(record);
    }
    
    public void removeRecord(LendedRecords record) {
        records.remove(record);
    }
    
    public List<LendedRecords> getActiveRecords() {
        return records.stream()
            .filter(r -> r.getReturnDate() == null || r.getReturnDate().isEmpty())
            .toList();
    }
    
    public List<Book> getBorrowedBooks() {
        return getActiveRecords().stream()
            .map(LendedRecords::getBook)
            .toList();
    }
    
    public List<LendedRecords> getAllRecords() {
        return new ArrayList<>(records);
    }
}