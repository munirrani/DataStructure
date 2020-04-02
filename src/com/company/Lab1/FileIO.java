package com.company.Lab1;

import java.io.IOException;

public interface FileIO {

    public void read(String fileName) throws IOException;
    public void write(String fileName, String line) throws IOException;

}
