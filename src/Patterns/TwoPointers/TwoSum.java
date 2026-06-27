package Patterns.TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 2, 7, 11, 15 };
		int target = 22;
		System.out.println(twoSum(nums, target));
	}

	public static int[] twoSum(int[] nums, int target) {
		int ans[] = new int[2];

		// maps
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			
			if (!freqMap.containsKey(target - nums[i])) {
				freqMap.put(nums[i], i);
			} else {
				ans[0] = i; // current index
				ans[1] = freqMap.get(target - nums[i]); // stored index
			}
		}

		return ans;

	}
}
