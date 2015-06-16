import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class MaxIndexProduct {


	static List<Integer> inputList;

	public static void main(String[] args) {

		Scanner in = null;
		try {
			inputList = new ArrayList<Integer>();
			in = new Scanner(System.in);
			int n = in.nextInt();
			for (int i=0; i<n; i++) {
				inputList.add(in.nextInt());
			}
			System.out.println(findMaxIndexProduct());
		} finally {
			in.close();
		}
	}

	private static int findMaxIndexProduct() {
		Stack<Integer> left = new Stack<Integer>();
		Stack<Integer> right = new Stack<Integer>();
		ArrayList<Integer> leftIndex = new ArrayList<Integer>();
		ArrayList<Integer> rightIndex = new ArrayList<Integer>();
		//processing left region
		int i=0;
		for (i : inputList) {
		while (left.peek() < inputList.get(i) && !left.isEmpty()) {
			left.pop();
		}
		if (left.isEmpty()) {
			leftIndex.add(0);
		} else {
			leftIndex.add(i);
		}
			left.push(inputList.get(i));
		}
			//processing right region
		
			for (int j=i; j<inputList.size(); j++) {
				while (left.peek() < inputList.get(j) && !left.isEmpty()) {
					right.pop();
				}
				if (right.isEmpty()) {
					rightIndex.add(0);
				} else {
					rightIndex.add(j);
				}
					right.push(inputList.get(j));
					
		return maxProduct;
	}
	}
}
