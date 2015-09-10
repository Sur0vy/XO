package com.Sur0vy.unit7;

import com.Sur0vy.unit7.printer.AdvConsolePrinter;
import com.Sur0vy.unit7.printer.ConsolePrinter;
import com.Sur0vy.unit7.printer.IPrinter;
import com.Sur0vy.unit7.reader.IReader;
import com.Sur0vy.unit7.reader.PredefinerReader;

public class Replacer {

    private final IReader reader;

    private final IPrinter printer;

    public Replacer(final IReader reader, final IPrinter printer) {
        this.reader = reader;
        this.printer = printer;
    }

    public void replace() {
        final String text = reader.read();
        final String replacedText = text.replace(":)", "=)");
        printer.print(replacedText);
    }

    public static void main(String[] args) {

        final IReader reader = new PredefinerReader("qwewerrg :) dskfljg;wekngdifjg:)");
        final IPrinter printer = new ConsolePrinter();
        final IPrinter aPrinter = new AdvConsolePrinter();
        final Replacer replacer = new Replacer(reader, aPrinter);
        replacer.replace();

    }
}
