package com.company;

public class Music implements Comparable<Music> {

    private String title;
    private String fileName;

    public Music(String title, String fileName) {
        this.title = title;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public String toString() {
        return "Music : " + title;
    }

    @Override
    public int compareTo(Music o) {
        return 0;
    }
}
