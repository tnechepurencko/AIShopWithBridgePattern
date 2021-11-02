package com.company;

import java.util.HashSet;
import java.util.Set;

public abstract class Product {
    protected static int idIterator = 0;

    private final int id;
    private final String name;
    private final double price;
    protected final Set<String> keywords = new HashSet<>();

    /**
     * @param userKeyword : the keyword
     * @return : does the keyword belong to this product?
     */
    public boolean isApplicable(String userKeyword) {
        return this.keywords.contains(userKeyword);
    }

    public Product(String type, double price) {
        this.id = idIterator;
        idIterator++;

        this.name = type;
        this.price = price;

        this.keywords.add(type);
        this.keywords.add(String.valueOf(id));
    }

    public void printProduct() {
        System.out.println("id: " + this.getId() + "; name: " + this.getName() + "; price: " + this.getPrice());
    }

    public Set<String> getKeywords() {
        return this.keywords;
    }

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
