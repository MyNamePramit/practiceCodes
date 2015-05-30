import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Solution {

	static int counter = 0;
	static Map<Cell, Cell> parentListTemp = new HashMap<Cell, Cell>();
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
			System.out.println("size of input list:"+inputList.size());
			System.out.println(DFS(inputList));
		} finally {
			in.close();
		}
	}

	private static int DFS(List<Cell> inputList) {
		Map<Cell, Object> parentList = new HashMap<Solution.Cell, Object>();
		Object dummy = new Object();
		int tempCounter = 0;
		for (Cell cell:inputList) {
			if (!parentList.containsKey(cell)) {
				parentList.put(cell, dummy);
				tempCounter=counter;
				DFSVisit(cell);
				if (counter>tempCounter)
					tempCounter=counter;
				counter=0;
				parentListTemp=new HashMap<Cell, Cell>();
			}
		}
		return tempCounter+1;
	}

	private static void DFSVisit(Cell cell) {

		for (Cell c : adjacent(cell)) {
			if (!parentListTemp.containsKey(c)) {
				parentListTemp.put(c, cell);
				counter++;
				System.out.println(counter);
				DFSVisit(cell);
			}
		}
	}

	private static List<Cell> adjacent(Cell cell) {
		List<Cell> neighbourList = new ArrayList<Solution.Cell>();
		for (Cell c : inputList) {
			if (c.getCol()==cell.getCol()-1 && c.getRow()==cell.getRow()-1 ||
					c.getCol()==cell.getCol() && c.getRow()==cell.getRow()-1 ||
					c.getCol()==cell.getCol()+1  && c.getRow()==cell.getRow()-1|| 
					c.getCol()==cell.getCol()-1  && c.getRow()==cell.getRow()  ||
					c.getCol()==cell.getCol()+1 && c.getRow()==cell.getRow()  ||
					c.getCol()==cell.getCol()-1  && c.getRow()==cell.getRow()+1 ||
					c.getCol()==cell.getCol()  && c.getRow()==cell.getRow()+1 ||
					c.getCol()==cell.getCol()+1  && c.getRow()==cell.getRow()+1) {
				neighbourList.add(c);
			}
		}
		return neighbourList;
	}

}
