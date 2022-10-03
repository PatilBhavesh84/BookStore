package com.bridgelabz.book.service;

import com.bridgelabz.book.dto.BookDTO;
import com.bridgelabz.book.entity.BookData;
import com.bridgelabz.book.exception.BookStoreException;
import com.bridgelabz.book.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepo;

    //Ability to serve to controller's insert api call
    public BookData insertBook(BookDTO bookdto) {
        BookData newBook = new BookData(bookdto);
        log.info("Book record inserted successfully");
        return bookRepo.save(newBook);
    }

    //Ability to serve to controller's retrieving all records api call
    public List<BookData> getAllBookRecords() {
        List<BookData> bookList = bookRepo.findAll();
        log.info("All book records retrieved successfully");
        return bookList;
    }

    //Ability to serve to controller's retrieving all records api call
    public List<BookData> getBookRecord(Integer id) {
        List<BookData> book = bookRepo.findByBookId(id);
        if (book.isEmpty()) {
            throw new BookStoreException("Book Record doesn't exists");
        } else {
            log.info("Book record retrieved successfully for id " + id);
            return book;
        }
    }

    //Ability to serve to controller's update record by id api call
    public BookData updateBookRecord(Integer id, BookDTO dto) {
        Optional<BookData> book = bookRepo.findById(id);
        if (book.isEmpty()) {
            throw new BookStoreException("Book Record doesn't exists");
        } else {
            BookData newBook = new BookData(dto);
            bookRepo.save(newBook);
            log.info("Book record updated successfully for id " + id);
            return newBook;
        }

    }

    //Ability to serve to controller's retrieve record by book name api call
    public List<BookData> getRecordByBookName(String bookName) {
        List<BookData> book = bookRepo.findByBookName(bookName);
        if (book.isEmpty()) {
            throw new BookStoreException("Book doesn't exists");
        } else {
            log.info("Book record retrieved successfully for Book Name : " + bookName);
            return book;
        }
    }

    //Ability to serve to controller's delete record api call
    public BookData deleteBookRecord(Integer id) {
        Optional<BookData> book = bookRepo.findById(id);
        if (book.isEmpty()) {
            throw new BookStoreException("Book Record doesn't exists");
        } else {
            bookRepo.deleteById(id);
            log.info("Book record deleted successfully for id " + id);
            return book.get();
        }
    }

    //Ability to serve to controller's sort all records in ascending order api call
    public List<BookData> sortRecordAsc() {
        List<BookData> listOfBooks = bookRepo.sortBooksAsc();
        log.info("Book records sorted in ascending order by price successfully");
        return listOfBooks;
    }

    //Ability to serve to controller's sort all records in descending order api call
    public List<BookData> sortRecordDesc() {
        List<BookData> listOfBooks = bookRepo.sortBooksDesc();
        log.info("Book records sorted in descending order by price successfully");
        return listOfBooks;
    }

    //Ability to serve to controller's update book quantity api call
    public BookData updateQuantity(Integer id, Integer quantity) {
        Optional<BookData> book = bookRepo.findById(id);
        if (book.isEmpty()) {
            throw new BookStoreException("Book Record doesn't exists");
        } else {
            book.get().setQuantity(quantity);
            bookRepo.save(book.get());
            log.info("Quantity for book record updated successfully for id " + id);
            return book.get();
        }
    }
}