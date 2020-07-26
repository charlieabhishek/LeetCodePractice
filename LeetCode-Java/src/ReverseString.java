//Write a function that reverses a string. The input string is given as an array of characters char[].

public class ReverseString {

	public void reverseString(char[] s) {
		int i = 0;
		int j = s.length-1;
		
		while(i<j) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		ReverseString rStr = new ReverseString();
		char[] charArr = {'h', 'e', 'l', 'l', 'o'};

		rStr.reverseString(charArr);
		String str = new String(charArr);
		
		System.out.println(str); 
	}
}
