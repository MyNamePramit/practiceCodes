import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class MaxIndexProduct {


	static List<Long> inputList;
	static List<Long> inputListR;
	public static void main(String[] args) {

		Scanner in = null;
		try {
			inputList = new ArrayList<Long>();
			inputListR = new ArrayList<Long>();
			in = new Scanner(System.in);
			long n = in.nextLong();
			for (long i=0; i<n; i++) {
				inputList.add(in.nextLong());
			}
			System.out.println(findMaxIndexProduct());
		} finally {
			in.close();
		}
	}

	private static Long findMaxIndexProduct() {
		Stack<Long> left = new Stack<Long>();
		Stack<Long> right = new Stack<Long>();
		ArrayList<Long> leftIndex = new ArrayList<Long>();
		ArrayList<Long> rightIndex = new ArrayList<Long>();
		//processing left region
		for (long i=0; i<inputList.size(); i++) {
			while (!left.isEmpty() && left.peek() <= inputList.get(i)) {
				left.pop();
			}
			if (left.isEmpty()) {
				leftIndex.add(0L);
			} else {
				leftIndex.add(inputList.indexOf(left.peek())+1);
			}
			left.push(inputList.get(i));
		}
		//processing right region
		for (int j=inputList.size()-1; j >=0; j-- ) {
			inputListR.add(inputList.get(j));
		}
		for (int j=0; j<inputListR.size(); j++) {
			while ( !right.isEmpty() && right.peek() <= inputListR.get(j)) {
				right.pop();
			}
			if (right.isEmpty()) {
				rightIndex.add(0);
			} else {
				rightIndex.add(inputListR.size()-inputListR.indexOf(right.peek()));
			}
			right.push(inputListR.get(j));
		}		

		int maxIndex = 0;

		for (int i=0; i<leftIndex.size() && i<rightIndex.size(); i++) {
			if (maxIndex<leftIndex.get(i)*rightIndex.get(i)) {
				maxIndex = leftIndex.get(i)*rightIndex.get(i);
			}
		}
		
		return maxIndex;
	}
}
