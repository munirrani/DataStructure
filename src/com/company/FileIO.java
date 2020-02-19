package com.company;

import java.io.File;
import java.io.IOException;

public interface FileIO {

    public void read(String fileName) throws IOException;
    public void write(String fileName, String line) throws IOException;

}
