package com.macdonnacha.micheal.app.sudoku;

import java.util.ArrayList;

public class Grid {
    private Cell[][] grid;


    public Grid(String numbers){
        prepareGrid(numbers);
    }


    private void prepareGrid(String numbers){
        this.grid = new Cell[9][9];
        char[] nums = numbers.toCharArray();
        int index = 0;

        for(int i=0; i<=8; i++){
            for(int j=0; j<=8; j++) {
                grid[i][j] = new Cell(i, j);

                int value = Character.digit(nums[index], 10);
                grid[i][j].setValue(value);
                index++;
            }
        }

    }

    public Cell[] getRow(int row){
        if(0 <= row && row < 9)     
            return this.grid[row];

        return this.grid[0];
    }

    public Cell[] getColumn(int column){
        ArrayList<Cell> col = new ArrayList<>();
        if(!(0 <= column && column < 9)){
            column = 0;
        } 


        for(int i=0; i<this.grid.length; i++){
            col.add(this.grid[i][column]);
        }

        return col.toArray(new Cell[0]);
    }


    public String solutionAsSingleLine(){
        StringBuilder sb = new StringBuilder();
        for (Cell[] rows : grid) {
            for(Cell c : rows){
                sb.append(c.value());
            }
        }
        return sb.toString();
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        //                 0   1   2    3   4   5    6   7   8
        //   sb.append("++---+---+---++---+---+---++---+---+---++\n");
        // 0 sb.append("||   |   |   ||   |   |   ||   |   |   ||\n");
        // 1 sb.append("||   |   |   ||   |   |   ||   |   |   ||\n");
        // 2 sb.append("||   |   |   ||   |   |   ||   |   |   ||\n");
        
        //  sb.append("++---+---+---++---+---+---++---+---+---++\n");
        // 3 sb.append("||   |   |   ||   |   |   ||   |   |   ||\n");
        // 4 sb.append("||   |   |   ||   |   |   ||   |   |   ||\n");
        // 5 sb.append("||   |   |   ||   |   |   ||   |   |   ||\n");
        
        //  sb.append("++---+---+---++---+---+---++---+---+---++\n");
        // 6 sb.append("||   |   |   ||   |   |   ||   |   |   ||\n");
        // 7 sb.append("||   |   |   ||   |   |   ||   |   |   ||\n");
        // 8 sb.append("||   |   |   ||   |   |   ||   |   |   ||\n");
        
        // sb.append("++---+---+---++---+---+---++---+---+---++\n");
        for(Cell[] rows : this.grid){
            for(Cell c : rows) {

            if(c.getX() % 3 == 0 && c.getY() == 0){
                sb.append(" ++---+---+---++---+---+---++---+---+---++\n");
            }

            String s = (String) (c.value() == 0 ? " " : "" + c.value());

            if(c.getY() % 3 == 0) {
                sb.append(" || ");
                sb.append(s);
            } else if (c.getY() == 8){
                sb.append(" | ");
                sb.append(s);
                sb.append(" ||\n");
            } else {
                sb.append(" | ");
                sb.append(s);
                
            }
        }
    }
    

        // for(int i=0; i<=8; i++){
        //     for(int j=0; j<=8; j++) {
        //         Cell c = grid[i][j];
                
        //         if(c.getX() % 3 == 0 && c.getY() == 0){
        //             sb.append(" ++---+---+---++---+---+---++---+---+---++\n");
        //         }

        //         String s = (String) (c.value() == 0 ? " " : "" + c.value());

        //         if(c.getY() % 3 == 0) {
        //             sb.append(" || ");
        //             sb.append(s);
        //         } else if (c.getY() == 8){
        //             sb.append(" | ");
        //             sb.append(s);
        //             sb.append(" ||\n");
        //         } else {
        //             sb.append(" | ");
        //             sb.append(s);
                    
        //         }
        //     }
        // } 

        sb.append(" ++---+---+---++---+---+---++---+---+---++");

        return sb.toString();
    }
}