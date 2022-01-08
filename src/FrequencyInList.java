import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;





public class FrequencyInList {
	
	public static void main(String[] args) {
		
		HashMap<Integer, Integer> freqHashMap = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Keep Entering all the integers then enter done");
		while(sc.hasNextInt()) {
			// Read integer
			int temp = sc.nextInt();

			// Check if it is there
			if(!freqHashMap.containsKey(temp)) {
				freqHashMap.put(temp, 0);
			}
			
			// Increment count
			freqHashMap.put(temp, freqHashMap.get(temp) +1);
			
		}
		
		Iterator hmIterator = freqHashMap.entrySet().iterator();
		
		while (hmIterator.hasNext()) {	 
            Map.Entry freqPair = (Map.Entry)hmIterator.next();
            System.out.println(freqPair.getKey() + " : " + freqPair.getValue());
        }
		
	}

}
