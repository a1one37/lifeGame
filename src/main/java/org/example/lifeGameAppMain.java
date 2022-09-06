package org.example;

import java.util.Scanner;

public class lifeGameAppMain {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Board board = new Board(300);

    do {
        board.print();
        sc.next();
    }while (board.nextStep() > 0);

    }
}