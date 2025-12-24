package book;



public class Book {




    private final String title;

    private final String author;

    private final String isbn;

    private final int publicationYear;

    private final String genre;

    private boolean isAvailable = true;

    private boolean isReserved = false;

    public Book(String title, String author, String isbn, int publicationYear,String genre) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear=publicationYear;
        this.genre=genre;
    }

    


    // Getters for final fields
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getGenre() {
        return genre;
    }

    // Getter and Setter for isAvailable
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    // Getter and Setter for isReserved
    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        this.isReserved = reserved;
    }


        
    
    public static class BookBuilder {
        private String title;
        private String author;
        private String isbn;
        private int publicationYear;
        private String genre;
        
        public BookBuilder setTitle(String title) {
            this.title = title;
            return this;
        }
        
        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }
        
        public BookBuilder setIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }
        
        public BookBuilder setPublicationYear(int year) {
            this.publicationYear = year;
            return this;
        }
        
        public BookBuilder setGenre(String genre) {
            this.genre = genre;
            return this;
        }
        
        public Book build() {
            return new Book(title, author, isbn, publicationYear, genre);
        }
    }


}

