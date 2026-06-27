package SlidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class RobinKarpAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String s = "worlds";
		// 0 1 2 3 4 5
		// w o r l d s => size = 6
		// i
		// System.out.println(s.substring(0, 6));

		String dna = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		System.out.println(findRepeatedDnaSequences(dna));
		System.out.println(robinKharp(dna));
	}


	/*
	 * Robin kharp algo (assigned characters to digits and calculated its
	 * weight-age) But what if instead of 4 chars we have 16 chars Currently our dna
	 * is formed from string that have only 4 characters 'A' 'C' 'G' 'T'
	 * 
	 * but what if we are given dna that is formed from string of 16 characters ??
	 * 
	 */

	public static List<String> robinKharp(String s) {

		int seq = 10;
		int limit = s.length() - seq;
		int sum = 0;
		HashSet<Integer> seen = new HashSet<>();

		HashSet<String> dups = new HashSet<>();

		List<String> ans = new ArrayList<>();

		for (int i = 0; i <= limit; i++) {

			String sub = s.substring(i, seq + i);

			if (seen.isEmpty())
				sum = sum + hashHelper(sub, seq);
			else {
				int remove = decodeString(s.charAt(i - 1)) * (Math.powExact(seq, seq - 1));
				sum = (((sum - remove) * seq) + decodeString(sub.charAt(seq - 1)));

			}
			if (!seen.contains(sum))
				seen.add(sum);
			else {
				dups.add(sub);
			}

		}
		for (String str : dups) {
			ans.add(str);
		}

		return ans;
	}

	public static int decodeString(char c) {

		if (c == 'A')
			return 0;
		else if (c == 'C')
			return 1;
		else if (c == 'G')
			return 2;
		else
			return 3;
	}

	public static int hashHelper(String sub, int seq) {
		int sum = 0;

		for (int j = (seq); j > 0; j--) {

			int decodedValue = decodeString(sub.charAt(j - 1));
			sum = sum + (Math.powExact(seq, (seq - j)) * decodedValue);

		}
		return sum;

	}

	/*
	 * Naive approach High space complexity.
	 */
	public static List<String> findRepeatedDnaSequences(String s) {
		// 0 1 2 3 4 5 6 7 8 9 10
		// C A A A A A A A A A C
		// i

		HashSet<String> seen = new HashSet<String>();
		HashSet<String> ans = new HashSet<String>();
		List<String> list = new ArrayList<>();
		int seq = 10;
		int limit = (s.length() - seq);

		for (int i = 0; i <= limit; i++) {

			String sub = s.substring(i, i + seq); // i+10 is exclusive not inclusive.

			boolean flag = seen.add(sub); // true when set writes data
											// false when set dont write data

			if (!flag) // flag is false when set dont write data i.e set already has that data
				ans.add(sub);

		}

		// copying to list.
		for (String str : ans) {
			list.add(str);
		}

		return list;
	}
}
