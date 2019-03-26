import java.util.HashMap;

public class IsUnique {
	
	String inputString = null;
	
	public IsUnique(String input) {
		this.inputString = input;
	}

	public boolean Compute() {
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsUnique test = new IsUnique("the sky");
		if(test.Compute()) {
			System.out.println("Passed!");
		}else {
			System.out.println("Failed");
		}
	}
}
