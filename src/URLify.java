import java.util.Scanner;

public class URLify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Input the String: ");
		String rawURL = in.nextLine();
		System.out.println("Input the length of the String: ");
		int urlLength = in.nextInt();
		in.close();
		
		URLify urlGenerator = new URLify();
		String url = urlGenerator.generateURLWithStringBuilder(rawURL.trim(), urlLength);
		System.out.println("Output: " + url);		
	}

	private String generateURLWithStringBuilder(String rawURL, int urlLength) {
		if(rawURL.length() != urlLength) {
			System.out.println("The length provided is incorrect!");
			return null;
		}
		
		char[] urlChars = rawURL.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for(char c: urlChars) {
			if(c == ' ') {
				sb.append("%20");
			}else {
				sb.append(c);
			}
		}
		
		return sb.toString();
	}	
}
