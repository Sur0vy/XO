package com.Sur0vy.view;

import java.util.Scanner;

public class MenuView {

    public static final int START_GAME = 1;
    public static final int LOAD_GAME = 2;
    public static final int GAME_SETTINGS = 3;
    public static final int EXIT_GAME = 4;

    public int showMenuWithResult() {
        showMenu();

        final Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case START_GAME:
                System.out.println("Start!");
                break;
            case LOAD_GAME:
                System.out.println("Load!");
                break;
            case GAME_SETTINGS:
                System.out.println("Settings!");
                break;
            case EXIT_GAME:
                System.out.println("Exit!");
                break;
            default:
                System.out.println("--------");
                break;
        }
        return choice;
    }

    private void showMenu(){
        System.out.println(START_GAME + " - Start");
        System.out.println(LOAD_GAME + " - Load");
        System.out.println(GAME_SETTINGS + " - Settings");
        System.out.println(EXIT_GAME + " - Exit");
        System.out.println("> ");
    }

}
