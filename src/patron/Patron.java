package patron;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Patron {

    private String name;
    private String memberId;
    private String email;
    private String phoneNumber;
    private List<String> currentlyBorrowedBookIds;
    private List<String> borrowHistoryIds;
    private List<String> preferredGenres;

    public Patron(String name, String memberId, String email, String phoneNumber) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (memberId == null || memberId.isEmpty()) {
            throw new IllegalArgumentException("Member ID cannot be null or empty");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        
        this.name = name;
        this.memberId = memberId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.currentlyBorrowedBookIds = new ArrayList<>();
        this.borrowHistoryIds = new ArrayList<>();
        this.preferredGenres = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<String> getCurrentlyBorrowedBookIds() {
        return new ArrayList<>(currentlyBorrowedBookIds);
    }

    public List<String> getBorrowHistoryIds() {
        return new ArrayList<>(borrowHistoryIds);
    }

    public List<String> getPreferredGenres() {
        return new ArrayList<>(preferredGenres);
    }

    public void addBorrowedBook(String bookId) {
        if (!currentlyBorrowedBookIds.contains(bookId)) {
            currentlyBorrowedBookIds.add(bookId);
        }
    }

    public void removeBorrowedBook(String bookId) {
        currentlyBorrowedBookIds.remove(bookId);
    }

    public void addToBorrowHistory(String bookId) {
        if (!borrowHistoryIds.contains(bookId)) {
            borrowHistoryIds.add(bookId);
        }
    }

    public void addPreferredGenre(String genre) {
        if (!preferredGenres.contains(genre)) {
            preferredGenres.add(genre);
        }
    }

   
}