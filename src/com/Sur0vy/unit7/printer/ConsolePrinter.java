package com.Sur0vy.unit7.printer;

import com.Sur0vy.unit7.printer.IPrinter;

/**
 * Created by Suvorov on 10.09.2015.
 */
public class ConsolePrinter implements IPrinter {

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
