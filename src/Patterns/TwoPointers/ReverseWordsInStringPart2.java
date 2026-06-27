package Patterns.TwoPointers;

public class ReverseWordsInStringPart2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "Mouse Ding Dong";
		System.out.println(reverseWords(s));
	}

	/*Constraints
	 * 
	 * 
	 * 
	 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
	 * 
	 * 
	 * 1 <= s.length <= 5 * 104 
	 * s contains printable ASCII characters. s does not
	 * contain any leading or trailing spaces. 
	 * There is at least one word in s. All
	 * the words in s are separated by a single space.
	 */
	public static String reverseWords(String s) {

		StringBuilder sb = new StringBuilder(s);

		int i = 0, j = 0;
		while (j < sb.length()) {

			// if not space then move ahead
			if (sb.charAt(j) != ' ')
				j++;

			else {

				// swap everything in between i -> k
				int k = j - 1;
				while (i < k) {
					char temp = sb.charAt(k);
					sb.setCharAt(k, sb.charAt(i));
					sb.setCharAt(i, temp);
					i++;
					k--;
				}
				// reassigning after swap
				j++;
				i = j;
			}

		}

		// if only one word is given
		if (j == sb.length()) {
			int k = j - 1;
			while (i < k) {
				char temp = sb.charAt(k);
				sb.setCharAt(k, sb.charAt(i));
				sb.setCharAt(i, temp);
				i++;
				k--;
			}
		}

		return new String(sb);
	}

}
