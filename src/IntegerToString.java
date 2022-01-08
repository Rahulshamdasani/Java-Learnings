// Write a program to convert Integer to string
// Input : 341
// Output: three four one
import java.util.*;
public class IntegerToString {
	public static void main(String args[]) {
		HashMap<Character,String> mapping = new HashMap()
        {{
            put('0', "Zero");
            put('1', "One");
            put('2', "Two");
            put('3', "Three");
            put('4', "Four");
            put('5', "Five");
            put('6', "Six");
            put('7', "Seven");
            put('8', "Eight");
            put('9', "Nine");
        }};
        while(true) {
	        System.out.println("Enter the number you want to convert or enter exit");
	        Scanner sc = new Scanner(System.in);
	        String s = "";
	        if(s.equals("exit")) {
	        	break;
	        }
	        long l = sc.nextLong();
	        if(l<0){
	            s = "-";
	        }
	        char a[] = String.valueOf(l).toCharArray();
	        for (int i =0; i<a.length; i++) {
	            // Taking care of all the numbers
	
	
	            if(mapping.containsKey(a[i])) {
	                // Adjusting spaces
	                if(s.length() > 1){
	                    s+=" ";
	                }
	                s += mapping.get(a[i]);
	            }
	        }
	        System.out.println(s);
	        System.out.println();
        }
		
	}
}
