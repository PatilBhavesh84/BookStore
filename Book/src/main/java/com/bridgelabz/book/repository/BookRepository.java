package com.bridgelabz.book.repository;

import com.bridgelabz.book.entity.BookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<BookData, Integer> {
    @Query(value = "select * from book where book_name LIKE :bookName%", nativeQuery = true)
    public List<BookData> findByBookName(String bookName);

    @Query(value = "select * from book ORDER BY price", nativeQuery = true)
    public List<BookData> sortBooksAsc();

    @Query(value = "select * from book ORDER BY price DESC", nativeQuery = true)
    public List<BookData> sortBooksDesc();

    @Query(value = "select * from book where bookid =:id", nativeQuery = true)
    public List<BookData> findByBookId(Integer id);
}
