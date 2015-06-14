import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class Itinerary {

	public static void main(String[] args) {

		Map<String, String> dataSet = new HashMap<String, String>();
		dataSet.put("Chennai", "Banglore");
		dataSet.put("Bombay", "Delhi");
		dataSet.put("Goa", "Chennai");
		dataSet.put("Delhi", "Goa");

		printResult(dataSet);

		Map<String, String> revDataSet = new HashMap<String, String>();
		for (Entry<String, String> entry : dataSet.entrySet()) {
			revDataSet.put(entry.getValue(), entry.getKey());
		}

		String start = null;
		for (Entry<String, String> entry : dataSet.entrySet()) {
			if (!revDataSet.containsKey(entry.getKey())) {
				start = entry.getKey();
				break;
			} 
		}
		if (start!= null) {
			int size = dataSet.size();
			while (size>0) {
				System.out.println(start + " --> " + dataSet.get(start));
				start = dataSet.get(start);
				size --;
			}
		} else {
			System.out.println("there exist a cycle in the input");
		}
	}

	private static void printResult(Map<String, String> dataSet) {
		for (Entry<String, String> entry : dataSet.entrySet()) {
			System.out.println(entry.getKey()+" --> "+entry.getValue());
		}
	}

}
