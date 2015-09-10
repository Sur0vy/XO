package com.Sur0vy.unit7.printer;

/**
 * Created by Suvorov on 10.09.2015.
 */
public class AdvConsolePrinter implements IPrinter {

    @Override
    public void print(String text) {
        System.out.println(text + text.length());

    }
}
