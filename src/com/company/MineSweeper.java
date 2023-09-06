package com.company;

import java.util.Arrays;
import java.util.Random;

public class MineSweeper {
	int mineCount;
    int rowCount;
    int columnCount;
    int rowSelection;
    int columnSelection;
    int [][] mineLocations;
    char[][] table;
    char[][] mineTable;
    int r1; 		//for random value
    int r2; 		//for random value
    boolean gameOver = false;

    public MineSweeper(int rowCount, int columnCount){
    	this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.mineCount = (rowCount * columnCount) / 4;
        this.table = new char[rowCount][columnCount];
    }

    public void getTable(){
        for(char[] x : this.table ){
            System.out.println(x);
        }
    }

    public void getMineTable(){
        for(char[] x : this.mineTable){
            System.out.println(x);
        }
    }

    public void mineLocationGenerator(){
    	Random rand = new Random();
    	this.mineLocations = new int[mineCount][2];
        this.mineTable = new char[this.rowCount][this.columnCount];
    	
    	for (int x=0; x<this.mineCount; x++) {
    		this.r1 = rand.nextInt(rowCount);
	        this.r2 = rand.nextInt(columnCount);
            this.mineTable[this.r1][this.r2] = 'x';
	        for (int y=0; y<=x; y++) {
	        	if(Arrays.equals(this.mineLocations[y], new int[]{this.r1, this.r2})){
	        		x--;
	        		break;
	        	}
	        }
	        this.mineLocations[x] = new int[]{this.r1, this.r2};
    	}

    }

    public void selection(int rowSelection, int columnSelection){
        this.rowSelection = rowSelection;
        this.columnSelection = columnSelection;
    }

    public void checkSelectionForBomb(){
        int[] selectionB = new int[] {this.rowSelection, this.columnSelection};
    	for(int x = 0; x<=this.mineCount-1; x++ ){
    		if(Arrays.equals(mineLocations[x], selectionB)){
    			this.gameOver = true;
    			break;
    		}
    	}
    }

    public void checkSelectionForNumber(){
    	int a = this.rowSelection;
    	int b = this.columnSelection;
    	int sum = 0;

        int[][] neighbors = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for (int[] neighbor : neighbors) {
            int neighborRow = a + neighbor[0];
            int neighborCol = b + neighbor[1];

            // Check if the neighbor is within the bounds of the board
            if (neighborRow >= 0 && neighborRow < rowCount && neighborCol >= 0 && neighborCol < columnCount) {
                if (mineTable[neighborRow][neighborCol] == 'x') {
                    sum++;
                }
            }
        }

        this.table[this.rowSelection][this.columnSelection] = Character.forDigit(sum, 10);
        System.out.println(sum);
    }































}