import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


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
		for (int i : inputList) {
			if (maxProduct < left*right)
				maxProduct = left*right;
		}
		return maxProduct;
	}

	private static int binarySearch(List<Integer> list, int start, int end, int key) {
		
		return 0;
	}

}
