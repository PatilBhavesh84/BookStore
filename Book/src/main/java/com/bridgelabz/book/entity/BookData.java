package com.bridgelabz.book.entity;

import com.bridgelabz.book.dto.BookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class BookData {
    @Id
    @GeneratedValue
    private Integer bookID;
    private String bookName;
    private String authorName;
    private Integer price;
    private Integer quantity;
    private String bookDescription;
    private String bookImg;

    public BookData(BookDTO dto) {
        this.bookName = dto.getBookName();
        this.authorName = dto.getAuthorName();
        this.price = dto.getPrice();
        this.quantity = dto.getQuantity();
        this.bookDescription = dto.getBookDescription();
        this.bookImg = dto.getBookImg();
    }
}