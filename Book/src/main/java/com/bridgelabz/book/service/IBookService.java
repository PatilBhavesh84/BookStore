package com.bridgelabz.book.service;

import com.bridgelabz.book.dto.BookDTO;
import com.bridgelabz.book.entity.BookData;

import java.util.List;

public interface IBookService {
    public BookData insertBook(BookDTO bookdto);

    public List<BookData> getAllBookRecords();

    public List<BookData> getBookRecord(Integer id);

    public BookData updateBookRecord(Integer id, BookDTO dto);

    public List<BookData> getRecordByBookName(String bookName);

    public BookData deleteBookRecord(Integer id);

    public List<BookData> sortRecordDesc();

    public List<BookData> sortRecordAsc();

    public BookData updateQuantity(Integer id, Integer quantity);
}
