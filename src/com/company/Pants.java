package com.company;

public class Pants extends Product {
    private String material;
    private String color;

    public Pants(String name, double price, String color, String material) {
        super(name, price);
        this.color = color;
        this.material = material;
        this.keywords.add(color);
        this.keywords.add(material);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void printProduct() {
        System.out.println("id: " + this.getId() + "; name: " + this.getName() + "; price: " + this.getPrice() +
                "; color: " + this.getColor() + "; material: " + this.getMaterial());
    }
}
