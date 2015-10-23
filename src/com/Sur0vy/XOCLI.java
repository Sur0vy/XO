package com.Sur0vy;

import com.Sur0vy.model.Field;
import com.Sur0vy.model.Figure;
import com.Sur0vy.model.Game;
import com.Sur0vy.model.Player;
import com.Sur0vy.view.ConsoleView;

public class XOCLI {

    public static void main(String[] args) {
        final String name1 = "Sur0vy";
        final String name2 = "Enemy";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game gameXO = new Game.Builder().players(players)
                                    .field(new Field(3))
                                    .name("XO")
                                    .build();

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while (consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }
    }
}

