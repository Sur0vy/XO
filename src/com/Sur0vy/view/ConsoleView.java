package com.Sur0vy.view;

import com.Sur0vy.controller.GameController;
import com.Sur0vy.model.Player;

import java.util.InputMismatchException;

import java.util.Scanner;

public class ConsoleView {

    private static final String LINE_SYMBOL = "--";

    public static final String COORDINATE_X = "X";

    public static final String COORDINATE_Y = "Y";

    public static final int INPUT_TRY_COUNT = 3;

    protected final GameController gameController;

    public ConsoleView(final GameController gameController) {
        assert gameController != null;
        this.gameController = gameController;
    }

    public void showGameName() {
        System.out.println(gameController.getGameName());
    }

    public void showPlayersName() {
        System.out.println(gameController.getPlayers());
    }

    public void showBoard() {
        for(int i = 0; i < gameController.getBoard().getFieldSize(); i++){
            showBoardLine(i);
            showLine(gameController.getBoard().getFieldSize());
        }
    }

    private void showLine(final int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(LINE_SYMBOL);
        }
        System.out.println();
    }

    private void showBoardLine(final  int row) {
        for(int i = 0; i < gameController.getBoard().getFieldSize(); i++) {
            System.out.print(gameController.getBoard().getFigure(row, i));
        }
        System.out.println();
    }

    public void start() {
        System.out.println("Pleas inputs coordinats");
        int x = getCoordinate(COORDINATE_X);
        int y = getCoordinate(COORDINATE_Y);
    }

    private int getCoordinate(final String coordinateName) {
        int counter = 0;
        do {
            System.out.print(String.format("Input the coordinate %s ", coordinateName));
            try {
                final Scanner in = new Scanner(System.in);
                return in.nextInt();
            } catch (final InputMismatchException e) {
                System.out.println("Incorrect coordinate");
                counter++;
            }
        } while(counter < INPUT_TRY_COUNT);
        return -1;
    }

    public void showPlayers() {
        for (Player player : gameController.getPlayers()) {
            System.out.println(player.getPlayerName());
        }
    }

}
