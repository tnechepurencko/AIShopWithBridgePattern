package com.company;

import java.util.Scanner;

public class Account {
    private final String login;
    private final String password;
    Scanner in = new Scanner(System.in);

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    protected int optionInput() {
        String[] input = in.nextLine().split(" ");
        int option = -1;

        if (input.length == 1 && input[0].length() == 1 && 48 < input[0].charAt(0) && input[0].charAt(0) < 57) {
            option = Integer.parseInt(input[0]);
        }
        return option;
    }

    protected int inputID() {
        int id;
        String[] input;

        input = in.nextLine().split(" ");
        id = -1;

        boolean isNumber = true;
        if (input.length == 1) {
            for (int i = 0; i < input[0].length(); i++) {
                if (48 > input[0].charAt(i) || input[0].charAt(i) > 57) {
                    isNumber = false;
                    break;
                }
            }
        }

        if (isNumber) {
            id = Integer.parseInt(input[0]);
        }

        return id;
    }
}