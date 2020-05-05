package com.company.Lab5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {

    int[][] position;
    String[] mazeLines = new String[10];
    int width = 0, height = 0;
    Stack<Position> positionStack;
    Position initialPosition;

    /*
    INDEX
    -2 - #
    -1 - Empty Space
    0 - S
    1 - F
    2 - .
    3 - visited
     */
    Maze() {
        setup();
        setupBoard();
        printBoard();
        while (true) {
            Position currentPosition = positionStack.peek();
            if (canMove(currentPosition)) {
                if (currentPosition != initialPosition) mark(currentPosition);
                positionStack.push(moveFromCurrentPosition(currentPosition));
            } else {
                markAsVisited(positionStack.pop());
            }
            if (isBesideFinish(currentPosition)) {
                mark(currentPosition);
                printBoard();
                break;
            }
        }
    }

    private boolean canMove(Position position) {
        if (isAvailable(position.x+1, position.y) || isAvailable(position.x-1, position.y)
                || isAvailable(position.x, position.y+1) || isAvailable(position.x, position.y-1)) {
            return true;
        }
        return false;
    }

    private Position moveFromCurrentPosition(Position position) { // returns Position object that it can move to
        Position newPosition = new Position();
        if (isAvailable(position.x+1, position.y)) {
            newPosition.x = position.x + 1;
            newPosition.y = position.y;
        } else if (isAvailable(position.x-1, position.y)) {
            newPosition.x = position.x - 1;
            newPosition.y = position.y;
        } else if (isAvailable(position.x, position.y+1)) {
            newPosition.y = position.y + 1;
            newPosition.x = position.x;
        } else if (isAvailable(position.x, position.y-1)){
            newPosition.y = position.y - 1;
            newPosition.x = position.x;
        }
        return newPosition;
    }

    private boolean isAvailable(int x, int y) {
        if (getValue(x, y) == -1) return true;
        return false;
    }

    private int getValue(int x, int y) {
        return position[x][y];
    }

    private boolean isBesideFinish(Position position) {
        if (getValue(position.x+1,position.y) == 1 || getValue(position.x-1,position.y) == 1 ||
                getValue(position.x, position.y+1) == 1 || getValue(position.x, position.y-1) == 1) {
            return true;
        }
        return false;
    }

    private void markAsVisited(Position currentPosition) {
        position[currentPosition.x][currentPosition.y] = 3;
    }

    private void mark(Position currentPosition) {
        position[currentPosition.x][currentPosition.y] = 2;
    }

    private void setup() {
        try {
            Scanner scanner = new Scanner(new FileInputStream(new File("maze.txt")));
            System.out.println("The original maze is");
            String line;
            int count = 0;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                mazeLines[count] = line;
                count++;
                width = line.length();
                height++;
            }
            position = new int[width][height];
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        positionStack = new Stack();
    }

    private void setupBoard() {
        String line;
        char c;
        initialPosition = new Position();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                line = mazeLines[i];
                c = line.charAt(j);
                if (c == '#') {
                    position[j][i] = -2;
                } else if (c == 'S') {
                    position[j][i] = 0;
                    initialPosition.x = j;
                    initialPosition.y = i;
                } else if (c == 'F') {
                    position[j][i] = 1;
                } else {
                    position[j][i] = -1;
                }
            }
        }
        positionStack.push(initialPosition);
    }

    private void printBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (position[j][i] == -2) {
                    System.out.print("# ");
                } else if (position[j][i] == -1) {
                    System.out.print("  ");
                } else if (position[j][i] == 0) {
                    System.out.print("S ");
                } else if (position[j][i] == 1) {
                    System.out.print("F ");
                } else if (position[j][i] == 2) {
                    System.out.print(". ");
                } else if (position[j][i] == 3) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public class Position implements Comparable {
        public int x, y;

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
}
