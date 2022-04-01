package com.example.devopsfirstprj.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    private String name;

    private float price;

    private String author;

    @Column(name="book_pages_num")
    private int bookPagesNum;

    private String genre;

    public Book() {
    }

    public Book(int id, String name, float price, String author, int bookPagesNum, String genre) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.bookPagesNum = bookPagesNum;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookPagesNum() {
        return bookPagesNum;
    }

    public void setBookPagesNum(int bookPagesNum) {
        this.bookPagesNum = bookPagesNum;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
