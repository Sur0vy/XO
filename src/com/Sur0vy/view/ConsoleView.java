package com.Sur0vy.view;

import com.Sur0vy.controller.CurrentMoveController;
import com.Sur0vy.controller.MoveController;
import com.Sur0vy.controller.WinnerController;
import com.Sur0vy.model.*;
import com.Sur0vy.model.exceptions.AlreadyOccupaiedException;
import com.Sur0vy.model.exceptions.InvalidPointException;
import com.Sur0vy.model.exceptions.NoWinnerException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView /*implements ICoordinateGetter*/ {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private  final MoveController moveController = new MoveController();

    private void showPlayers(final Game game) {
        System.out.println("XO players:");
        for (Player player: game) {
            System.out.format("Player %s play figure %s \n", player.getName(), player.getFigure());
        }
    }

    public void show(final Game game) {
        System.out.format("Game name: %s\n", game.getName());
        final Field field = game.getField();
        showPlayers(game);
        for (int y = 0; y < field.getSize(); y++) {
            if (y != 0) {
                printHorisontalSeparator();
            }
            printLine(field, y);
        }
    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        try {
            final Figure winner = winnerController.getWinner(field);
            System.out.format("Winner is: %s\n", winner);
            return false;
        } catch (NoWinnerException e) {
            final Figure currentFigure = currentMoveController.currentMove(field);
            if (currentFigure == null) {
                System.out.println("No winner and no moves left!");
                return false;
            }
            System.out.format("Please enter move point for %s:\n", currentFigure);
            final Point point = askPoint();
            try {
                moveController.applyFigure(field, point, currentFigure);
            } catch (InvalidPointException | AlreadyOccupaiedException e2) {
                System.out.println("Point is invalid!");
            }
            return true;
        }
    }

    private Point askPoint() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String coordinateName) {
        System.out.format("Please input %s:", coordinateName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("Point is invalid!");
            return askCoordinate(coordinateName);
        }
    }

    private void printLine(final Field field,
                           final int y) {
        for (int x = 0; x < field.getSize(); x++) {
            if (x != 0) {
                printVerticalSeparator();
            }
            final Figure figure;
            try {
                figure = field.getFigure(new Point(x, y));
            } catch (InvalidPointException e) {
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : "   ");
        }
        System.out.println();
    }

    private void printHorisontalSeparator() {
        System.out.println("-----------");
    }

    private void printVerticalSeparator() {
        System.out.print("|");
    }

}
