package ru.netology.javaqamvn.catalog.domain;

public class Book extends Product {
    private String author;

    public Book(int id, String name, String author, int price) {
        super(id, name, price);
        this.author = author;
    }
}
