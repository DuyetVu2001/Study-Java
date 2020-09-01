package ex3.booksmanagement.model;

public class BookReaderManagement {
    private Reader reader;
    private Book book;
    private int numOfBorrow;
    private String state;
    private int totalOfBorrowred;

    public BookReaderManagement() {
    }

    public BookReaderManagement(Reader reader) {
        this.reader = reader;
    }

    public BookReaderManagement(Reader reader, Book book, int numOfBorrow, String state, int totalOfBorrowred) {
        this.reader = reader;
        this.book = book;
        this.numOfBorrow = numOfBorrow;
        this.state = state;
        this.totalOfBorrowred = totalOfBorrowred;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getNumOfBorrow() {
        return numOfBorrow;
    }

    public void setNumOfBorrow(int numOfBorrow) {
        this.numOfBorrow = numOfBorrow;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getTotalOfBorrowred() {
        return totalOfBorrowred;
    }

    public void setTotalOfBorrowred(int totalOfBorrowred) {
        this.totalOfBorrowred = totalOfBorrowred;
    }

    @Override
    public String toString() {
        return "BookReaderManagement{" +
                "reader=" + reader.getReaderID() +
                ", book=" + book.getBookID() +
                ", numOfBorrow=" + numOfBorrow +
                ", state='" + state + '\'' +
                ", totalOfBorrowred=" + totalOfBorrowred +
                '}';
    }
}

