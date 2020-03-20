package com.company.Lab5;

public class NQueen {

    boolean[][] board;
    int N;

    public NQueen() {
        Stack<Integer> stack = new Stack<>();
        int column = 0;
        N = 6;
        int row = 0;
        board = new boolean[N][N];
        reset();

        while (true) {
            column = isValid(row, column);
            if (column != -1) { // there is a valid position
                stack.push(column);
                board[row][column] = true;
                column = 0;
                row++;
            }
            if (column == -1) { //there is no valid position
                if (stack.isEmpty()) {
                    break;
                } else {
                    row--;
                    column = stack.pop();
                    board[row][column] = false;
                    column++;
                }
            }
            if (stack.getSize() == N) {
                for (int i = 0; i < N; i++) {
                    int num = stack.pop();
                    printQLine(N, num);
                    if (i == N - 1) column = num;
                }
                System.out.println();
                reset();
                row = 0;
                column++;
            }
        }
    }

    private void printQLine(int N, int index) {
        for (int i = 0; i < N; i++) {
            if (i != index)
                System.out.print("* ");
            else
                System.out.print("Q ");
        }
        System.out.println();
    }

    private void reset() {
        for(int i = 0; i < N; i++) for (int j = 0; j < N; j++) board[i][j] = false;
    }

    private int isValid(int row, int column) {
        for (int i = column; i < N; i++) {
            if (canBePlaced(row, i)) return i; //Returns column index that can be placed
        }
        return -1;
    }

    private boolean canBePlaced(int row, int column) {

        int i, j;
        //Check left to right
        for (i = 0; i < board.length; i++) if (board[row][i] == true) return false;

        //Check top to bottom
        for (i = 0; i < board.length; i++) if (board[i][column] == true) return false;

        // Check diagonally
        for (i = row, j = column; i >= 0 && j < board.length; i--, j++) if (board[i][j] == true) return false; // top left
        for (i = row, j = column; i < board.length && j >= 0; i++, j--) if (board[i][j] == true) return false; // bottom right
        for (i = row, j = column; i >= 0 && j >= 0; i--, j--) if (board[i][j] == true) return false; // bottom left
        for (i = row, j = column; i < board.length && j < board.length; i++, j++) if (board[i][j] == true) return false; // top right

        return true;
    }

}
