package Patterns.RandomProblems;

import java.util.HashMap;
import java.util.Map;

public class findOneCommonOccourences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] words1 = { "leetcode", "is", "leetcode", "is", "amazing", "and", "fantastic" };
		String[] words2 = { "leetcode", "is", "leetcode", "is", "fantastic" };

		System.out.println(countWords(words1, words2));

	}

	public static int countWords(String[] words1, String[] words2) {

		// declare a hashmap to store words and its freq
		Map<String, Integer> fmap = new HashMap<>();
		for (String str : words1) {
			fmap.put(str, (fmap.getOrDefault(str, 0) + 1));
		}

		// check if that words present in words2
		for (String str : words2) {
			// check if fmap has this word in words1
			if (fmap.containsKey(str) && fmap.get(str) <= 1) {
				fmap.put(str, fmap.get(str) - 1);
			}
		}
		int counter = 0;
		// scan the map for those values which have 0
		for (Map.Entry<String, Integer> mapSet : fmap.entrySet()) {
			if (mapSet.getValue() == 0)
				counter++;
		}
		return counter;

	}

}
