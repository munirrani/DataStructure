package com.company;

import java.io.*;

public class BinaryFile implements FileIO {

    @Override
    public void read(String fileName) throws IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(fileName)));
        System.out.println(objectInputStream.readUTF());
        objectInputStream.close();
    }

    @Override
    public void write(String fileName, String line) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
        objectOutputStream.writeUTF(line);
        objectOutputStream.flush();
    }
}
