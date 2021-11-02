package com.company;

public class Dress extends Product {
    private String color;
    private String length;

    public Dress(String name, double price, String color, String length) {
        super(name, price);
        this.color = color;
        this.length = length;
        this.keywords.add(color);
        this.keywords.add(length);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void printProduct() {
        System.out.println("id: " + this.getId() + "; name: " + this.getName() + "; price: " + this.getPrice() +
                "; color: " + this.getColor() + "; length: " + this.getLength());
    }
}