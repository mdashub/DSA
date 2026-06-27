package SlidingWindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "dvdf";

		System.out.println(lengthOfLongestSubstring(s));

	}

	public static int lengthOfLongestSubstring(String s) {
		// 0 1 2 3 4 5 6 7 8 9
		// a b c d e f c k g i
		// i
		// j
		// length =

		char[] ch = s.toCharArray();

		int i = 0;
		int j = 0;
		
		//to store the elements
		HashSet<Character> set = new HashSet<>();
		int len = 0; //to find the length
		while (j < ch.length) {
			
			if (!set.contains(ch[j])) {
				set.add(ch[j]); 

			} else {
				while (ch[i] != ch[j]) { //remove from the set till condition
					set.remove(ch[i++]);
				}
				i = i + 1; //
			}
			len = Math.max(j - i + 1, len);
			j++;
		}

		return len;
	}
}
