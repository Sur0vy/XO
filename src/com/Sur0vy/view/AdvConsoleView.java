package com.Sur0vy.view;

import com.Sur0vy.controller.GameController;

public class AdvConsoleView extends ConsoleView {

    final private String STARS = "***";

    public AdvConsoleView(GameController gameController) {
        super(gameController);
    }

    private void printStars(final boolean endLine) {
        if (endLine) {
            System.out.println(STARS);
        } else {
            System.out.print(STARS);
        }
    }

    @Override
    public void showGameName() {
        printStars(false);
        System.out.print(gameController.getGameName());
        printStars(true);
    }

}
