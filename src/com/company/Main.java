package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Row Count");
        int rowCount = scan.nextInt();

        System.out.println("Enter Column Count");
        int columnCount = scan.nextInt();

        System.out.println("Table Preparing");

        int rowSelection;
        int columnSelection;

        int roundCount = (rowCount * columnCount) - ((rowCount * columnCount)/4);

        MineSweeper mine = new MineSweeper(rowCount, columnCount);

        mine.mineLocationGenerator();

        while (!mine.gameOver && roundCount != 0) {

            roundCount -= 1;

            System.out.println("Mine Table Layout");
            //mine.mineTable();
            System.out.println("-------------------------------------");
            System.out.println("-------------------------------------");
            mine.getTable();
            System.out.println("-------------------------------------");
            System.out.println("-------------------------------------");
            mine.getMineTable();
            System.out.println("Select a Row Number: ");
            rowSelection = scan.nextInt();
            System.out.println("Select a Column Number: ");
            columnSelection = scan.nextInt();

            mine.selection(rowSelection, columnSelection);

            mine.checkSelectionForBomb();
            mine.checkSelectionForNumber();
        }
        if (!mine.gameOver){
            System.out.println("!!!!!!!!!.YOU WIN.!!!!!!!!!");
        }
        else{
            System.out.println("GAME OVER");
        }

    }
}
