package ru.netology.javaqamvn.catalog.domain;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String name, String manufacturer, int price) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }
}
