package com.pramit.practice.codes;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class ConnectedCellsInAGrid {

    public static class Cell {

        int row;
        int col;
        Cell parent;

        Cell (int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public Cell getParent() {
            return parent;
        }

        public void setParent(Cell parent) {
            this.parent = parent;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Cell other = (Cell) obj;
            if (col != other.col)
                return false;
            if (row != other.row)
                return false;
            return true;
        }
    }

    public static void main(String[] args) {

        Scanner in = null;
        List<Cell> inputList = new LinkedList<Cell>();
        // scanning input and obtaining a list of cell objects
        try {
            in = new Scanner(System.in);
            int noOfRows = in.nextInt();
            int noOfCols = in.nextInt();
            for (int i=0; i<noOfRows; i++) {
                for (int j=0; j<noOfCols; j++) {
                    inputList.add(new Cell(i,j));
                }
            }
            System.out.println(findMaxLength(inputList));
        } finally {
            in.close();
        }
    }

    private static int findMaxLength(List<Cell> inputList) {
        
        return null;
    }

}
