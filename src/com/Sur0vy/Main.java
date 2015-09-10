package com.Sur0vy;

import com.Sur0vy.controller.GameController;
import com.Sur0vy.model.*;
import com.Sur0vy.view.*;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.StringTokenizer;

public class Main {

    public static final int PLAYERS_COUNT = 2;

    public static void main(String[] args) {

//        MenuView menu = new MenuView();
//        menu.showMenuWithResult();

        final Board board = new Board();
        final Player[] players = new Player[2];

        players[0] = new Player("Sur0vy", Figure.X);
        players[1] = new Player("Guest", Figure.O);

        final Figure figureX = Figure.X;
        final Figure figureO = Figure.O;

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

        String s = "123";

        Integer i = new Integer(s);


        System.out.println(i);

        //int i = fromString(chars);



//        System.out.println(invertToken(st));
//        System.out.println(invertEachToken(st));
//        System.out.println(targetSimbolCount(st, ' '));
//        if (st.toLowerCase() == s1t.toLowerCase()){
//
//        }
        //consoleView.showPlayers();

    }

    private static String invertToken(String string){
        StringBuilder out = new StringBuilder(string.length());
        for (int i = string.length() - 1; i >= 0; i --) {
            out.append(string.charAt(i));
        }
        return out.toString();
    }

    private static String invertEachToken(final String string) {
        StringBuilder out = new StringBuilder(string.length());
        int sIndex = 0;
        int eIndex = 0;
        while (eIndex != string.length()) {
            eIndex = string.indexOf(' ', sIndex);
            if (sIndex == eIndex) {
                out.append(' ');
                eIndex ++;
            } else {
                if (eIndex == -1) {
                    eIndex = string.length();
                }
                out.append(invertToken(string.substring(sIndex, eIndex)));
            }
            sIndex = eIndex;
        }
        return out.toString();
    }

    private static int targetSimbolCount(String string, char target) {
        int count = 0;
        int sIndex = 0;
        do {
            sIndex = string.indexOf(target, sIndex);
            if (sIndex != -1) {
                count ++;
                sIndex ++;
            }
        } while (sIndex != -1);
        return count;
    }


    public static int fromString(final char[] chars) {
        // BEGIN (write your solution here)
        String out = trimIn(chars);
        return Integer.valueOf(out).intValue();
        // END
    }

    private static String trimIn (final char[] chars) {
        if (chars.length == 0) {
            return "0";
        } else {
            String out = String.valueOf(chars);
            return out.substring(0, 3);
        }
    }





}
