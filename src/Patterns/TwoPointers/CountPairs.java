package Patterns.TwoPointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(-6);
		nums.add(-2);
		nums.add(5);
		nums.add(-2);
		nums.add(-7);
		nums.add(-1);
		nums.add(3);
		System.out.println(countPairs(nums, -2));

	}

	public static int countPairs(List<Integer> nums, int target) {

		Collections.sort(nums);
		int pairs = 0;

		int start = 0;
		int end = nums.size()-1;

		while (start < end) {
			if (nums.get(start) + nums.get(end) < target)
				pairs += end - start++;
			else
				end--;

		}

		return pairs;
	}

}
