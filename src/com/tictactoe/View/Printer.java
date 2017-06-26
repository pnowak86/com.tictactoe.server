package com.tictactoe.View;

/**
 * Created by RENT on 2017-06-22.
 */
public class Printer {


    public void showTable(String[][] table, int x, int y){



        //game.getField();
        //int i;
        int j = 0;
        while(j<x) {

            for (int k = 0; k < y; k++) {
                System.out.print(" " + table[j][k] + " ");
                if (k < y - 1) {
                    System.out.print(" | ");
                }
            }
            if(j<table.length-1){
            System.out.println();
            for (int k = 0; k < y-1 ; k++) {

                System.out.print("  - " + "  + ");

                if (k == y - 2) {
                   System.out.print(" - ");
                    System.out.println();
                }
            }}
            j++;
        }
//
//        for (int k = 0; k < table.length ; k++) {
//            System.out.print(" " + table[j][k] +" ");
//            if(k <table.length-1){
//                System.out.print(" | ");
//            }
//        }
//        System.out.println();
//        for (int k = 0; k < table.length -1 ; k++) {
//
//            System.out.print( "  - " + "  + ");
//
//            if(k==table.length-2){
//                System.out.print(" - ");
//                System.out.println();
//            }
//        }
//        j++;
//
//        for (int k = 0; k < table.length ; k++) {
//            System.out.print(" " + table[j][k] +" ");
//            if(k <table.length-1){
//                System.out.print(" | ");
//            }
//        }
        System.out.println();
        System.out.println();
        //return null;
    }

    public String changeToString(String[][] table){
        String tableToString = null;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                // field[i][j] = String.valueOf(i) + " " + String.valueOf(j);
                tableToString = tableToString + table[i][j];
            }
        }

        return tableToString.substring(5);
    }


}
