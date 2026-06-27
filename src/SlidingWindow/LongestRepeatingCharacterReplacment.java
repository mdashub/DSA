package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "CCAAABBBB";
		int k = 2;

		/// System.out.println(characterReplacement_TimeLimitExceeds(s, k));
		System.out.println(characterReplacement(s, k));

	}

	public static int characterReplacement(String s, int k) {

		int i = 0;
		int n = s.length();
		int j = 0;
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		int maxFre = 0;
		int maxSubs = 0;

		while (j < n) {
			//map mein frequency update
			hmap.put(s.charAt(j), hmap.getOrDefault(s.charAt(j), 0) + 1);
			maxFre = Math.max(maxFre, hmap.get(s.charAt(j)));
			
			// number of operations required = length of substring - maximumFreq 
			//example
			// CCAAA
			// i   
			//     j
			//length = 5 
			//maximumFreq = 3 (of A)
			//ops = 5-3 => 2 (two CC can be made to AA )
			
			int ops = (j - i + 1) - maxFre;

			while (ops > k) {
				resizeMap(hmap, s, i);
				i++;

				maxFre = reCalculateFreq(hmap);
				ops = (j - i + 1) - maxFre;

			}

			if (ops <= k) {
				// substring ka length
				maxSubs = Math.max(maxSubs, j - i + 1);
			}

			j++;

		}

		return maxSubs;

	}

	public static void resizeMap(HashMap<Character, Integer> hmap, String s, int i) {

		Character key = s.charAt(i);
		int value = hmap.get(key);
		int remove = value - 1;
		hmap.put(key, remove);
		if (hmap.get(key) == 0)
			hmap.remove(key);
	}

	public static int reCalculateFreq(HashMap<Character, Integer> f) {

		int max = 0;

		for (Map.Entry<Character, Integer> kv : f.entrySet()) {
			int value = kv.getValue();
			max = Math.max(value, max);
		}

		return max;
	}

	public static int characterReplacement_TimeLimitExceeds(String s, int k) {

		int n = s.length();
		int maxSubs = 0;
		// finding all subarrays
		for (int i = 0; i < n; i++) {
			HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
			int maxFre = 0;
			for (int j = i; j < n; j++) {

				hmap.put(s.charAt(j), hmap.getOrDefault(s.charAt(j), 0) + 1);
				maxFre = Math.max(maxFre, hmap.get(s.charAt(j)));
				int ops = (j - i + 1) - maxFre;

				if (ops <= k) {
					// substring ka length
					maxSubs = Math.max(maxSubs, j - i + 1);
				} else
					break;
			}
		}

		return maxSubs;
	}

}
