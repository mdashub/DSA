package StringLeetcode;

import java.util.HashMap;
import java.util.Map;

public class OccourencesEqual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abacbc";
		
		System.out.println(areOccurrencesEqual(str));
	}

	public static boolean areOccurrencesEqual(String s) {

		char ch[] = s.toCharArray();
		HashMap<Character, Integer> hmap = new HashMap<>();

		// frequency map
		for (Character c : ch) {
			hmap.put(c, hmap.getOrDefault(c, 0) + 1);
		}

		
		int oldValue = hmap.get(ch[0]);

		// [a=3 b=3 c=3]
		for (Map.Entry<Character, Integer> ks : hmap.entrySet()) {

			if (oldValue != ks.getValue())
				return false;

		}

		return true;
	}

}
