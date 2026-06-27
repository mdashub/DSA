package Patterns.TwoPointers;

public class ValidPalindrome2 {

	public static void main(String[] args) {

		String s = "abybxa";
		System.out.println(deletingOneChar(s));

	}

	public static boolean deletingOneChar(String s) {

		int start = 0;
		int end = s.length() - 1;

		while (start < end) {

			if (s.charAt(start) != s.charAt(end)) {
				return ((deletingOneChar(s, start, end - 1)) || (deletingOneChar(s, start+1, end)));
			}
			start++; end --;
		}
		return true;
	}

	public static boolean deletingOneChar(String s, int start, int end) {

		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--))
				return false;
		}
		return true;
	}

}
