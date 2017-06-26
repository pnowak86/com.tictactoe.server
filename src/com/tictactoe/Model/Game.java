package com.tictactoe.Model;

/**
 * Created by RENT on 2017-06-22.
 */
public class Game {


    private String[][] field;
    private String sign;

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    private int y;
    private int x;

    public String getSign() {
        return sign;
    }


    public String[][] getField() {

        return field;
    }

    public String[][] createField() {
        y = 3;
        x = 3;
        field = new String[x][y];

        int idx = 1;
        for (int i = 0; i < x; i++) {

            for (int j = 0; j < y; j++) {
                // field[i][j] = String.valueOf(i) + " " + String.valueOf(j);
                field[i][j] = " " + Integer.toString(+idx) +" ";
                idx++;
            }
        }

//        field[0][0] = "1";
//        field[0][1] = "2";
//        field[0][2] = "3";
//
//        field[1][0] = "4";
//        field[1][1] = "5";
//        field[1][2] = "6";
//
//
//        field[2][0] = "7";
//        field[2][1] = "8";
//        field[2][2] = "9";


        return field;
    }
//
//    public void putSomethingToTable(){
//    field[0][0] = "x";
//
//    }


    public String makeMove(int x, int y, int player) {


        if (!field[x][y].equals(" X ") && !field[x][y].equals(" Y ")) {
            if (player == 1) {
                sign = " X ";
            } else if (player == 2) {
                sign = " O ";
            }
            field[x][y] = sign;

            return "You made a move! " + sign + "on " + x + " " + y;
        } else {
            return

                    "This position is taken! Choose different one";
        }
    }


    public boolean seekForWinner() {


        return (checkRows() || checkColums() || checkLeftDiagonal() || checkRightDiagonal());
        // return (checkRows() || checkColums || checkDiagonal);
    }


    public boolean checkRows() {
        for (int i = 0; i < getY(); i++) {
            if (checkInside(field[i][0], field[i][1], field[i][2]) == true) {
                return true;
            }
        }
        return false;
    }

    public boolean checkColums() {
        for (int i = 0; i < getY(); i++) {
            if (checkInside(field[0][i], field[1][i], field[2][i]) == true) {
                return true;
            }
        }
        return false;
    }

    public boolean checkLeftDiagonal() {

        String[] temptable = new String[getY()];
        for (int i = 0; i < getY(); i++) {

            temptable[i] = field[i][i];
        }
        int j = 0;
        if (checkInside(temptable[j], temptable[j + 1], temptable[j + 2])) {

            return true;
        }
        return false;
    }

    public boolean checkRightDiagonal() {

        String[] temptable = new String[getY()];
        int k = getY() - 1;
        for (int i = 0; i < getY(); i++) {

            temptable[i] = field[i][k];
            System.out.println(temptable[i]);
            k--;
        }
        int j = 0;
        if (checkInside(temptable[j], temptable[j + 1], temptable[j + 2])) {

            return true;
        }
        return false;
    }

    public boolean checkIfTie() {
        int multiply = getX() * getY();
        int add = 0;
        for (int i = 0; i < getX(); i++) {
            for (int j = 0; j < getY(); j++) {
                if (field[i][j].equals(" X ") || field[i][j].equals(" Y ")) {
                    add++;
                }
            }
        }
        if (multiply == add) {
            System.out.println(multiply);
            System.out.println(add);
            return true;
        }

        return false;
    }

    private boolean checkInside(String c1, String c2, String c3) {
        return ((c1.equals(c2)) && (c2.equals(c3)));

    }


}
