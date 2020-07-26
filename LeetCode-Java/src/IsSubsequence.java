
public class IsSubsequence {

	public boolean isSubsequence(String s, String t) {
		int x = 0;
		int sIndex = 0;

		if (s.length() == 0) {
			return true;
	    }

		while (x < t.length()) {
			if (t.charAt(x) == s.charAt(sIndex)) {
				sIndex++;
				if (sIndex == s.length()) {
					return true;
				}
			}
			x++;
		}
		return false;
	}

	public static void main(String[] args) {
		IsSubsequence isSub = new IsSubsequence();
		System.out.println(isSub.isSubsequence("axc", "ahbgdc"));
	}
}
