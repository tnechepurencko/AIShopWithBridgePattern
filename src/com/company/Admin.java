package com.company;

import java.util.Scanner;

public class Admin extends Account {
    Scanner in = new Scanner(System.in);

    public Admin(String login, String password) {
        super(login, password);
    }

    private void addProduct(AIShop aiShop) {
        int option;

        System.out.println("Choose a kind of the product: 1-dress, 2-white shirt, 3-pants");

        boolean over = false;
        while (!over) {
            option = this.optionInput();
            switch (option) {
                case 1 -> {
                    String name = in.nextLine();
                    double price = in.nextDouble();
                    String color = in.nextLine();
                    String length = in.nextLine();

                    aiShop.addProduct(new Dress(name, price, color, length));
                    over = true;
                }
                case 2 -> {
                    String name = in.nextLine();
                    double price = in.nextDouble();

                    aiShop.addProduct(new WhiteShirt(name, price));
                    over = true;
                }
                case 3 -> {
                    String name = in.nextLine();
                    double price = in.nextDouble();
                    String color = in.nextLine();
                    String material = in.nextLine();

                    aiShop.addProduct(new Pants(name, price, color, material));
                    over = true;
                }
                default -> System.out.println("We have no such option. Try again");
            }
        }
    }

    public void removeProduct(AIShop aiShop) {
        System.out.println("Enter the ID of the product, please:");

        int id = this.inputID();

        aiShop.removeProduct(id);
        System.out.println("the product is removed");
    }

    public void productsManagement(AIShop aiShop) {
        System.out.println("Welcome to the products management!!!!!!!!!!!!!");
        boolean over = false;
        int option;

        while (!over) {
            System.out.println("Choose an option: 1-add the product, " +
                    "2-remove the product, 3-get products, 4-finish work");

            option = this.optionInput();

            switch (option) {
                case 1 -> this.addProduct(aiShop);
                case 2 -> this.removeProduct(aiShop);
                case 3 -> aiShop.printProducts();
                case 4 -> {
                    System.out.println("Work is finished. Thank you!");
                    over = true;
                }
                default -> System.out.println("We have no such option. Try again");
            }
        }
    }
}