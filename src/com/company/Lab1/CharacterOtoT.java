package com.company.Lab1;

public class CharacterOtoT extends Banner {

    public CharacterOtoT(char character) {
        this.character = character;

        switch (character) {
            case 'O':
                line[0] = "";
                line[1] = "";
                line[2] = "";
                line[3] = "";
                line[4] = "";
                break;
            case 'P':
                line[0] = "";
                line[1] = "";
                line[2] = "";
                line[3] = "";
                line[4] = "";
                break;
            case 'Q':
                line[0] = "";
                line[1] = "";
                line[2] = "";
                line[3] = "";
                line[4] = "";
                break;
            case 'R':
                line[0] = "";
                line[1] = "";
                line[2] = "";
                line[3] = "";
                line[4] = "";
                break;
            case 'S':
                line[0] = "  ***";
                line[1] = " *   ";
                line[2] = "  *  ";
                line[3] = "   * ";
                line[4] = "***  ";
                break;
            case 'T':
                line[0] = "*****";
                line[1] = "  *  ";
                line[2] = "  *  ";
                line[3] = "  *  ";
                line[4] = "  *  ";
                break;
        }
    }
}
