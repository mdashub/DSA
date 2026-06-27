package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		int nums[] = { 1, 5, 4, 2, 9, 9, 9 };
		int k = 3;
		System.out.println(maximumSubarraySum(nums, k));
		System.out.println(maximumSubarraySum2(nums, k));
	}

	// high iq
	public static long maximumSubarraySum(int[] nums, int k) {

		int[] freq = new int[100001];

		long sum = 0;
		long maxSum = 0;
		int distinct = 0;
		//0 1   2  3  4  5  6
		//1, 5, 4, 2, 9, 9, 9
	//             i
    //   sum = 12
	//     d = 4
    // maxSum = 10 
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];

			int value = nums[i];
			if (freq[value] == 0)
				distinct++;

			freq[value] = freq[value] + 1;

			if (i >= k) {
				sum = sum - nums[i - k];
				freq[nums[i - k]]--;
				if (freq[nums[i - k]] == 0) {
					distinct--;
				}
			}

			// all unique elements of size of sub-array
			if ( distinct == k) {
				maxSum = (maxSum < sum) ? sum : maxSum;
			}

		}

		return maxSum;

	}

	// low iq
	public static long maximumSubarraySum2(int[] nums, int k) {
		Map<Integer, Integer> hmap = new HashMap<>();
		int start = 0;
		long sum = 0, maxSum = 0;

		for (int end = 0; end < nums.length; end++) {
			// Add current element
			hmap.put(nums[end], hmap.getOrDefault(nums[end], 0) + 1);
			sum += nums[end];

			// Shrink window until valid (no dups, size <= k)
			while (hmap.get(nums[end]) > 1 || end - start + 1 > k) {
				hmap.put(nums[start], hmap.get(nums[start]) - 1);
				if (hmap.get(nums[start]) == 0)
					hmap.remove(nums[start]); // removal
				sum -= nums[start];
				start++;
			}

			// Check exact size
			if (end - start + 1 == k)
				maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

}
