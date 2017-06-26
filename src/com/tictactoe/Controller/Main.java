package com.tictactoe.Controller;

import com.tictactoe.Model.Game;
import com.tictactoe.View.Printer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Game game = new Game();

        game.createField();
        // printer.showTable(game.getField());
//        System.out.println();
//        System.out.println();
//        System.out.println("-----------------------");
        //game.putSomethingToTable();
//        System.out.println(game.getField()[0][0]);
//
//        System.out.println( game.makeMove(0,0,1));
//        System.out.println( game.makeMove(0,0,2));
//        System.out.println( game.makeMove(1,1,2));
//        printer.showTable(game.getField());

        //printer.printer();
//        printer.printer();


        Scanner sc = new Scanner(System.in);
        int option= 0;
        while(option != 3) {
            System.out.println("Welcome to our game! Please choose what you wanna do:");
            System.out.println("1. Show game field 2. Make move 3. QUIT");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("All fields are shown like that: X Y");
                    printer.showTable(game.getField(), game.getX(), game.getY());
                    option =0;
                    break;
                case 2:
                    int x;
                    int y;
                    int player;
                    System.out.println("Please type in where you wanna write a sign:");
                    System.out.println("X:");


                    x = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Y:");
                    y = sc.nextInt();
                    sc.nextLine();
                    System.out.println("What sign? 1 - X | 2 - O");
                    player = sc.nextInt();
                    sc.nextLine();
                    System.out.println(game.makeMove(x, y, player));
                    printer.showTable(game.getField(), game.getX(), game.getY());
                    System.out.println("check if won" + game.seekForWinner());
                    System.out.println("check for tie " +game.checkIfTie());
                    if(game.seekForWinner() || game.checkIfTie()){
                        option =3;
                    }
            }
        }


    }
}