<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Solution {

	static int counter = 0;
	static Map<Cell, Boolean> parentListTemp = new HashMap<Cell, Boolean>();
	static List<Cell> inputList = new ArrayList<Solution.Cell>();

	public static class Cell {
		int row,col;

		Cell(int row, int col) {
			this.row = row;
			this.col = col;
		}
		public int getRow() {
			return row;
		}
		public int getCol() {
			return col;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + col;
			result = prime * result + row;
			return result;
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

		//scanning input and obtaining required
		Scanner in = null;
		try {
			in = new Scanner(System.in);
			int row = in.nextInt();
			int col = in.nextInt();
			for (int i=0; i<row; i++) {
				for (int j=0; j<col; j++) {
					if (in.nextInt() == 1)
						inputList.add(new Cell(i,j));
				}
			}
			System.out.println(DFS(inputList));
		} finally {
			in.close();
		}
	}

	private static int DFS(List<Cell> inputList) {
		Map<Cell, Object> parentList = new HashMap<Solution.Cell, Object>();
		int tempCounter = 0;
		for (Cell cell:inputList) {
			if (!parentListTemp.containsKey(cell)) {
				parentListTemp.put(cell, true);
				DFSVisit(cell);
				if (counter>tempCounter)
					tempCounter=counter;
				counter=0;
			}
		}
		return tempCounter+1;
	}

	private static void DFSVisit(Cell cell) {
		parentListTemp.put(cell, true);
		for (Cell c : adjacent(cell)) {
			if (!parentListTemp.containsKey(c)) {
				counter++;
				DFSVisit(c);
			}
		}
	}

	private static List<Cell> adjacent(Cell cell) {
		List<Cell> neighbourList = new ArrayList<Solution.Cell>();
		for (Cell c : inputList) {
			if (c.getCol()==cell.getCol()-1 && c.getRow()==cell.getRow()-1 ||
					c.getCol()==cell.getCol() && c.getRow()==cell.getRow()-1 ||
					c.getCol()==cell.getCol()+1 && c.getRow()==cell.getRow()-1|| 
					c.getCol()==cell.getCol()-1 && c.getRow()==cell.getRow() ||
					c.getCol()==cell.getCol()+1 && c.getRow()==cell.getRow() ||
					c.getCol()==cell.getCol()-1 && c.getRow()==cell.getRow()+1 ||
					c.getCol()==cell.getCol() && c.getRow()==cell.getRow()+1 ||
					c.getCol()==cell.getCol()+1 && c.getRow()==cell.getRow()+1) {
				neighbourList.add(c);
			}
		}
		return neighbourList;
	}
=======
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
>>>>>>> 1398dd06217aa4729243fef22d780ed0bf7e6c69

}
