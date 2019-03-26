import java.util.HashMap;

public class IsUnique {
	
	String inputString = null;
	
	public IsUnique(String input) {
		this.inputString = input;
	}

	public boolean ComputeWithHashMap() {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c : this.inputString.toCharArray()) {
			if((Integer)map.get(c) != null) {
				return false;
			}else {
				map.put(c, 1);
			}
		}
		
		return true;
	}
	
	public boolean ComputeInline() {
		int checker = 0;
		
		for(int i=0; i<this.inputString.length(); i++) {
			int value = this.inputString.charAt(i) - 'a';
			if((checker & (1 << value)) > 0) {
				return false;
			}else {
				checker = checker | (1 << value);
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsUnique test = new IsUnique("the sky is the limit");
		if(test.ComputeInline()) {
			System.out.println("Passed!");
		}else {
			System.out.println("Failed!");
		}
		
		test = new IsUnique("the sky");
		if(test.ComputeWithHashMap()) {
			System.out.println("Passed!");
		}else {
			System.out.println("Failed!");
		}

	}
}
