package com.Sur0vy.unit7.reader;

public class PredefinerReader implements IReader{

    private final String str;

    public PredefinerReader(String str) {
        this.str = str;
    }

    @Override
    public String read() {
        return str;
    }
}
