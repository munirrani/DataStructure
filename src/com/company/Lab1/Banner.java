package com.company.Lab1;

public abstract class Banner {

    protected String[] line = new String[5];
    protected char character;
    public String getLineAt(int index) {
        return line[index];
    }
}
