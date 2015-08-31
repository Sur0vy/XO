package com.Sur0vy;

import com.Sur0vy.controller.GameController;
import com.Sur0vy.model.*;
import com.Sur0vy.view.*;

import java.awt.*;

public class Main {

    public static final int PLAYERS_COUNT = 2;

    public static void main(String[] args) {

//        MenuView menu = new MenuView();
//        menu.showMenuWithResult();

        final Board board = new Board();
        final Player[] players = new Player[2];

        players[0] = new Player("Sur0vy", new Figure("X"));
        players[1] = new Player("Guest", new Figure("O"));

        final Figure figureX = new Figure("X");
        final Figure figureO = new Figure("O");

        final GameController game = new GameController("XO", players, board);
        final AdvConsoleView advConsoleView = new AdvConsoleView(game);
        startGame(advConsoleView);

        board.setFigure(0, 0, figureX);
        board.setFigure(1, 1, figureX);
        board.setFigure(2, 2, figureX);

        System.out.println(game.winner().getPlayerName());
//        if (game.currentPlayer() == players[1]) {
//            System.out.println(game.currentPlayer().getPlayerName());
//            System.out.println("sadsdfghjkl");
//        }
    }

    private static void startGame(final ConsoleView consoleView) {
        consoleView.showGameName();
        consoleView.showBoard();
        consoleView.start();
        //consoleView.showPlayers();


    }


}
