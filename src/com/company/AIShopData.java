package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AIShopData {
    Scanner scanner = new Scanner(System.in);
    private final List<Account> admins = new ArrayList<>();
    private final List<Account> users = new ArrayList<>();
    AIShop aiShop;

    public AIShopData(AIShop aiShop) {
        this.aiShop = aiShop;
        initialise();
    }

    public void programManagement() {
        String[] input;
        int option;
        while (true) {
            System.out.println("Welcome to the AI Shop system! Choose an option: 1-registration, 2-login, 3-exit");

            input = scanner.nextLine().split(" ");
            option = -1;

            if (input.length == 1 && input[0].length() == 1 && 48 < input[0].charAt(0) && input[0].charAt(0) < 57) {
                option = Integer.parseInt(input[0]);
            }

            switch(option) {
                case 1 -> registration();
                case 2 -> {
                    logIn();
                    return;
                }
                case 3 -> {
                    System.out.println("Thank you for visiting our AIShop!");
                    return;
                }
                default -> System.out.println("This option does not exist: try again");
            }
        }
    }

    public void initialise() {
        admins.add(new Admin("Admin", "00000000"));
        admins.add(new Admin("DeputyAdmin", "11111111"));
    }

    public void registration() {
        boolean end = false;
        while (!end) {
            System.out.println("Enter your login");
            String login = scanner.nextLine();

            if (!containsLogin(users, login)) {
                System.out.println("Enter your password");
                String password = scanner.nextLine();

                users.add(new User(login, password));
                System.out.println("You are registered");
                end = true;
            } else {
                System.out.println("This login already exists");
            }
        }
    }

    public void logIn() {
        String[] input;
        int option;
        boolean end = false;
        while (!end) {
            System.out.println("Choose the type of your account: 1-Admin, 2-Customer, 3-return back");

            input = scanner.nextLine().split(" ");
            option = -1;

            if (input.length == 1 && input[0].length() == 1 && 48 < input[0].charAt(0) && input[0].charAt(0) < 57) {
                option = Integer.parseInt(input[0]);
            }

            switch (option) {
                case 1 -> {
                    System.out.println("Enter your login");
                    String login = scanner.nextLine();

                    if (containsLogin(admins, login)) {
                        System.out.println("Enter your password");
                        String password = scanner.nextLine();

                        if (findLogin(admins, login).getPassword().equals(password)) {
                            end = true;
                            adminActionsMenu((Admin) findLogin(admins, login), aiShop);
                        } else System.out.println("Your password is incorrect");
                    } else {
                        System.out.println("This login does not exist");
                    }
                }
                case 2 -> {
                    System.out.println("Enter your login");
                    String login = scanner.nextLine();

                    if (containsLogin(users, login)) {
                        System.out.println("Enter your password");
                        String password = scanner.nextLine();

                        if (findLogin(users, login).getPassword().equals(password)) {
                            end = true;
                            userActionsMenu((User)findLogin(users, login), aiShop);
                        } else System.out.println("Your password is incorrect");
                    } else {
                        System.out.println("This login does not exist");
                    }
                }
                case 3 -> programManagement();
                default -> System.out.println("We do not have such option");
            }
        }
    }

    public void adminActionsMenu(Admin admin, AIShop aiShop) {
        System.out.println("You have successfully logged in!");

        String[] input;
        int option;
        boolean end = false;
        while (!end) {
            System.out.println("Choose an option, please: 1-log out, 2-manage the warehouse");

            input = scanner.nextLine().split(" ");
            option = -1;

            if (input.length == 1 && input[0].length() == 1 && 48 < input[0].charAt(0) && input[0].charAt(0) < 57) {
                option = Integer.parseInt(input[0]);
            }

            switch (option) {
                case 1 -> {
                    end = true;
                    System.out.println("You have logged out successfully");
                    programManagement();
                }
                case 2 -> admin.productsManagement(aiShop);
                default -> System.out.println("We do not have such option");
            }
        }
    }

    public void userActionsMenu(User user, AIShop aiShop) {
        System.out.println("You have successfully logged in!");

        String[] input;
        int option;
        boolean end = false;
        while (!end) {
            System.out.println("Choose an option, please: 1-log out, 2-assembly an order");

            input = scanner.nextLine().split(" ");
            option = -1;

            if (input.length == 1 && input[0].length() == 1 && 48 < input[0].charAt(0) && input[0].charAt(0) < 57) {
                option = Integer.parseInt(input[0]);
            }

            switch (option) {
                case 1 -> {
                    end = true;
                    System.out.println("You have logged out successfully");
                    programManagement();
                }
                case 2 -> user.orderAssembly(aiShop);
                default -> System.out.println("We do not have such option");
            }
        }
    }

    public boolean containsLogin(List<Account> accounts, String login) {
        for (Account account : accounts) {
            if (account.getLogin().equals(login))
                return true;
        }
        return false;
    }

    public Account findLogin(List<Account> accounts, String login) {
        for (Account account : accounts) {
            if (account.getLogin().equals(login))
                return account;
        }
        return null;
    }
}
