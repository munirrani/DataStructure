package com.company;

import java.io.*;
import java.util.Scanner;

public class TextFile implements FileIO {
    /*
     Create FileIO Interface. The interface consists of two methods that write to the file and read
     from the file. Create two classes that implement the interface. The TextFile class read and writes
     sentences to the text file while the BinaryFile class read and writes sentences to the binary file.
     Create a Tester class to test the program, given output below.
     */

    @Override
    public void read(String fileName) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(new File(fileName)));
        while (scanner.hasNextLine()) System.out.println(scanner.nextLine());
        scanner.close();
    }

    @Override
    public void write(String fileName, String line) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(fileName), true));
        printWriter.println(line);
        printWriter.close();
    }
}
