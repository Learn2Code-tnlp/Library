package org.sample;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String bookName) {
        super(bookName);
    }
}
