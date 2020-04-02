package com.company.Lab1;

import java.io.*;
import java.util.Scanner;

public class TextFile implements FileIO {

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
