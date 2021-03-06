package com.sudokusolver.app.sudoku;

import java.util.ArrayList;
import java.util.Arrays;

public class Grid {
    private Cell[][] grid;
    private boolean silentFlag;

    public Grid(String numbers, boolean flag) {
        this.silentFlag = flag;
        prepareGrid(numbers);

    }

    private void prepareGrid(String numbers) {
        this.grid = new Cell[9][9];
        char[] nums = numbers.toCharArray();
        int index = 0;

        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                grid[i][j] = new Cell(i, j);

                int value = Character.digit(nums[index], 10);
                grid[i][j].setValue(value);
                index++;
            }
        }

    }

    public Cell getCell(int x, int y) {
        return this.grid[x][y];
    }

    public Cell[] getRow(int row) {
        if (0 <= row && row < 9)
            return this.grid[row];

        return this.grid[0];
    }

    public Cell[] getRow(Cell cell) {
        int row = cell.getX();
        return this.grid[row];
    }

    public Cell[] getColumn(int column) {
        ArrayList<Cell> col = new ArrayList<>();
        if (!(0 <= column && column < 9)) {
            column = 0;
        }

        for (int i = 0; i < this.grid.length; i++) {
            col.add(this.grid[i][column]);
        }

        return col.toArray(new Cell[0]);
    }

    public Cell[] getColumn(Cell cell) {
        ArrayList<Cell> col = new ArrayList<>();
        for (int i = 0; i < this.grid.length; i++) {
            col.add(this.grid[i][cell.getY()]);
        }

        return col.toArray(new Cell[0]);
    }

    public Cell[] getSquare(int quadrant) {
        ArrayList<Cell> quad = new ArrayList<>();
        int initialI = 0;
        int initialJ = 0;
        int resetJ;
        if (!(0 <= quadrant && quadrant < 9)) {
            quadrant = 0;
        }

        switch (quadrant) {
            case 0:
                initialI = 0;
                initialJ = 0;
                break;
            case 1:
                initialI = 0;
                initialJ = 3;
                break;
            case 2:
                initialI = 0;
                initialJ = 6;
                break;
            case 3:
                initialI = 3;
                initialJ = 0;
                break;
            case 4:
                initialI = 3;
                initialJ = 3;
                break;
            case 5:
                initialI = 3;
                initialJ = 6;
                break;
            case 6:
                initialI = 6;
                initialJ = 0;
                break;
            case 7:
                initialI = 6;
                initialJ = 3;
                break;
            case 8:
                initialI = 6;
                initialJ = 6;
                break;
        }

        resetJ = initialJ;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                quad.add(this.grid[initialI][initialJ]);
                initialJ++;
            }
            initialI++;
            initialJ = resetJ;
        }

        return quad.toArray(new Cell[0]);
    }

    public Cell[] getBox(Cell cell) {
        ArrayList<Cell> quad = new ArrayList<>();
        int initialI = 0;
        int initialJ = 0;
        int resetJ;
        int quadrant = cell.getQuadrant();

        switch (quadrant) {
            case 0:
                initialI = 0;
                initialJ = 0;
                break;
            case 1:
                initialI = 0;
                initialJ = 3;
                break;
            case 2:
                initialI = 0;
                initialJ = 6;
                break;
            case 3:
                initialI = 3;
                initialJ = 0;
                break;
            case 4:
                initialI = 3;
                initialJ = 3;
                break;
            case 5:
                initialI = 3;
                initialJ = 6;
                break;
            case 6:
                initialI = 6;
                initialJ = 0;
                break;
            case 7:
                initialI = 6;
                initialJ = 3;
                break;
            case 8:
                initialI = 6;
                initialJ = 6;
                break;
        }

        resetJ = initialJ;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                quad.add(this.grid[initialI][initialJ]);
                initialJ++;
            }
            initialI++;
            initialJ = resetJ;
        }

        return quad.toArray(new Cell[0]);
    }

    public String solutionAsSingleLine() {
        StringBuilder sb = new StringBuilder();
        for (Cell[] rows : grid) {
            for (Cell c : rows) {
                sb.append(c.value());
            }
        }
        return sb.toString();


        // return Arrays.asList(grid).stream()
        //                           .flatmap(row -> Arrays.asList(row))
        //                           .mapToObj(cell -> (Cell)cell)
        //                           .mapToInt(cell -> cell.value())
        //                           .collect(Collectors.joining());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        // 0 1 2 3 4 5 6 7 8
        // sb.append("++---+---+---++---+---+---++---+---+---++\n");
        // 0 sb.append("|| | | || | | || | | ||\n");
        // 1 sb.append("|| | | || | | || | | ||\n");
        // 2 sb.append("|| | | || | | || | | ||\n");

        // sb.append("++---+---+---++---+---+---++---+---+---++\n");
        // 3 sb.append("|| | | || | | || | | ||\n");
        // 4 sb.append("|| | | || | | || | | ||\n");
        // 5 sb.append("|| | | || | | || | | ||\n");

        // sb.append("++---+---+---++---+---+---++---+---+---++\n");
        // 6 sb.append("|| | | || | | || | | ||\n");
        // 7 sb.append("|| | | || | | || | | ||\n");
        // 8 sb.append("|| | | || | | || | | ||\n");

        // sb.append("++---+---+---++---+---+---++---+---+---++\n");
        for (Cell[] rows : this.grid) {
            for (Cell c : rows) {

                if (c.getX() % 3 == 0 && c.getY() == 0) {
                    sb.append(" ++---+---+---++---+---+---++---+---+---++\n");
                }

                String s = (String) (c.value() == 0 ? " " : "" + c.value());

                if (c.getY() % 3 == 0) {
                    sb.append(" || ");
                    sb.append(s);
                } else if (c.getY() == 8) {
                    sb.append(" | ");
                    sb.append(s);
                    sb.append(" ||\n");
                } else {
                    sb.append(" | ");
                    sb.append(s);

                }
            }
        }

        sb.append(" ++---+---+---++---+---+---++---+---+---++");

        return sb.toString();
    }

    public String fullGridInfo(){
        StringBuilder sb =  new StringBuilder();
        sb.append(" ++---+---+---++---+---+---++---+---+---++\n");
        for(int row=0; row<9; row++){
            for(int i=0; i<3; i++){
                sb.append(" ||");
                for(int col=0; col<9; col++) {
                    if(i == 0){
                        if(this.grid[row][col].isSolved()){
                            sb.append("   ");
                        }else{
                            
                            if(this.grid[row][col].getPossibleCandidates().contains("1")){
                                sb.append("1");
                            }else{
                                sb.append(" ");
                            }

                            if(this.grid[row][col].getPossibleCandidates().contains("2")){
                                sb.append("2");
                            }else{
                                sb.append(" ");
                            }

                            if(this.grid[row][col].getPossibleCandidates().contains("3")){
                                sb.append("3");
                            }else{
                                sb.append(" ");
                            }
                        }

                        

                        if(col == 2 || col == 5 || col == 8){
                            sb.append("||");
                        }else{
                            sb.append("|");
                        }
                    }else if(i == 1){

                        if(this.grid[row][col].isSolved()){
                            sb.append("(" + this.grid[row][col].value() + ")");
                        }else{

                            if(this.grid[row][col].getPossibleCandidates().contains("4")){
                                sb.append("4");
                            }else{
                                sb.append(" ");
                            }

                            if(this.grid[row][col].getPossibleCandidates().contains("5")){
                                sb.append("5");
                            }else{
                                sb.append(" ");
                            }

                            if(this.grid[row][col].getPossibleCandidates().contains("6")){
                                sb.append("6");
                            }else{
                                sb.append(" ");
                            }
                        }

                        

                        if(col == 2 || col == 5 || col == 8){
                            sb.append("||");
                        }else{
                            sb.append("|");
                        }
                    }else if(i == 2){
                        if(this.grid[row][col].isSolved()){
                            sb.append("   ");
                        }else{
                            if(this.grid[row][col].getPossibleCandidates().contains("7")){
                                sb.append("7");
                            }else{
                                sb.append(" ");
                            }

                            if(this.grid[row][col].getPossibleCandidates().contains("8")){
                                sb.append("8");
                            }else{
                                sb.append(" ");
                            }

                            if(this.grid[row][col].getPossibleCandidates().contains("9")){
                                sb.append("9");
                            }else{
                                sb.append(" ");
                            }
                        }
                        

                        if(col == 2 || col == 5 || col == 8){
                            sb.append("||");
                        }else{
                            sb.append("|");
                        }
                    }
                }
                sb.append("\n");
            }
        sb.append(" ++---+---+---++---+---+---++---+---+---++\n");
        if(row == 2 || row == 5){
            sb.append(" ++---+---+---++---+---+---++---+---+---++\n");
        }
        }

        return sb.toString();
    }


    public boolean isSolved(){
        boolean noEmptyCells = !this.solutionAsSingleLine().contains("0");
        int sumOfSudoku = this.solutionAsSingleLine()
                              .chars()
                              .mapToObj(Character::getNumericValue)
                              .reduce(0, (subtotal, element) -> subtotal + element);
        
        return noEmptyCells && sumOfSudoku == 405;
    }

    public boolean getSilentFlag(){
        return this.silentFlag;
    }
}