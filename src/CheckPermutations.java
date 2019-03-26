import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class CheckPermutations {

	static String inputString_1, inputString_2;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Input first String: ");
		
		Scanner in = new Scanner(System.in);
        inputString_1 = in.nextLine();
        
        System.out.println("Input second String: ");
        inputString_2 = in.nextLine();
        
        in.close();
        
        CheckPermutations checker = new CheckPermutations();
        
        System.out.println("Result using Sorting: ");
        if(checker.IsPermutationUsingSorting(inputString_1, inputString_2)) {
        	System.out.println("Pass!");
        }else {
        	System.out.println("Fail!");
        }
  
        System.out.println("Result using Hashing: ");
        if(checker.IsPermutationUsingHashMaps(inputString_1, inputString_2)) {
        	System.out.println("Pass!");
        }else {
        	System.out.println("Fail!");
        }

	}


	private boolean IsPermutationUsingHashMaps(String a, String b) {
		//create a HashMap
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		//read the characters of the first string and add them to the HashMap
		char[] charArrayA = a.toCharArray();
		for(char c: charArrayA) {
			if(map.get(c) != null) {
				map.put(c, ((int)map.get(c)) + 1);
			}else {
				map.put(c, 1);
			}
		}
		
		//displayMap(map);
		
		//read the characters of the second string and subtract them from the HashMap
		char[] charArrayB = b.toCharArray();
		for(char c: charArrayB) {
			if(map.get(c) != null) {
				if((int)map.get(c) > 1) {
					map.put(c, ((int)map.get(c)) - 1);
				}else if((int)map.get(c) == 1) {
					map.remove(c);
				}
			}else {
				return false;
			}
		}
		
		if(map.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}

	//this method is used for debugging
	private void displayMap(HashMap<Character, Integer> map) {
		Iterator<Entry<Character, Integer>> it = map.entrySet().iterator();
	    while (it.hasNext()) {
	        Entry<Character, Integer> pair = it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        //it.remove(); // avoids a ConcurrentModificationException
	    }
	}


	private boolean IsPermutationUsingSorting(String a, String b) {
		
		//if the two strings have different lengths, fail the check
		if(a.length() != b.length()) return false;
		
		//sort the characters of the first string
		char[] charArrayA = a.toCharArray();
		Arrays.sort(charArrayA);
		String newA = new String(charArrayA);
		
		//sort the characters of the second string
		char[] charArrayB = b.toCharArray();
		Arrays.sort(charArrayB);
		String newB = new String(charArrayB);
		
		//check if the two new strings are the same
		if(!newA.equals(newB)) {
			return false;
		}
		
		return true;
	}

}
