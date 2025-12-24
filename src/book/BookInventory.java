package book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookInventory {
    private List<Book> books = new ArrayList<>();
    
    public void addBook(Book book) {
        if (book == null || book.getIsbn() == null || book.getIsbn().isEmpty()) {
            throw new IllegalArgumentException("Invalid book");
        }
        books.add(book);
    }
    
    public Book removeBook(String isbn) {
        if (isbn == null || isbn.isEmpty()) {
            return null;
        }
        
        Optional<Book> bookToRemove = books.stream()
            .filter(book -> book.getIsbn().equals(isbn))  // USE .equals() NOT ==
            .findFirst();
            
        if (bookToRemove.isPresent()) {
            books.remove(bookToRemove.get());
            return bookToRemove.get();
        }
        return null;
    }

     public boolean updateBook(String isbn, Book updatedBook) {
        Optional<Book> existingBook = findByIsbn(isbn);
        if (existingBook.isPresent()) {
            int index = books.indexOf(existingBook.get());
            books.set(index, updatedBook);
            
            return true;
        }
        
        return false;
    }

      // FIX: Add search by author
    public List<Book> findByAuthor(String author) {
        
        if (author == null || author.isEmpty()) {
            return new ArrayList<>();
        }
        List<Book> results = books.stream()
            .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
            .toList();
        
        return results;
    }
    
    public Optional<Book> findByIsbn(String isbn) {
        if (isbn == null || isbn.isEmpty()) {
            return Optional.empty();
        }
        return books.stream()
            .filter(book -> book.getIsbn().equals(isbn))
            .findFirst();
    }
    
    public Optional<Book> findByTitle(String title) {
        if (title == null || title.isEmpty()) {
            return Optional.empty();
        }
        return books.stream()
            .filter(book -> book.getTitle().equalsIgnoreCase(title))
            .findFirst();
    }
    
    public List<Book> searchByAuthor(String author) {
        if (author == null || author.isEmpty()) {
            return new ArrayList<>();
        }
        return books.stream()
            .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
            .toList();
    }
    
    public List<Book> getAvailableBooks() {
        return books.stream()
            .filter(Book::isAvailable)
            .toList();
    }
    
    public List<Book> getBooks() {
        return new ArrayList<>(books);  // Return copy, not reference
    }
}