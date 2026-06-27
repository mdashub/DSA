package Patterns.TwoPointers;


//https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/description/
public class AppendCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "z", t = "abcde";

		System.out.println(appendCharacters(s, t));
	}

	public static int appendCharacters(String s, String t) {

		int s_cursor = 0;
		int t_cursor = 0;
		while (t_cursor < t.length() && s_cursor < s.length()) {
			if (s.charAt(s_cursor++) != t.charAt(t_cursor)) {
				s_cursor++;
				t_cursor++;
			} else
				s_cursor++; 
		}
		return t.length() - t_cursor;

	}
}
