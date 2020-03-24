package com.company.Lab6;

public class Packet implements Comparable<Packet> {

    private int priority, packetNumber;
    private String data;

    public Packet(int type, int packetNumber) {
        this.packetNumber = packetNumber;
        priority = type;
        data = getType();
    }

    private String getType() {
        switch (priority) {
            case 2:
                return "Voice";
            case 1:
                return "Video";
            case 0:
                return "Data";
        }
        return "";
    }

    public int getPriority() { return priority; };

    @Override
    public int compareTo(Packet o) {
        return priority - o.getPriority();
    }

    public String getData() { return data; }

    public String toString() {
        return data + " " + packetNumber;
    }
}
