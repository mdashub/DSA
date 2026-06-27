package SlidingWindow;

public class MinimumSizeSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = { 2, 3, 1, 2, 4, 5 };
		int target = 7;

		System.out.println(minSubArrayLen(target, nums));

	}

	public static int minSubArrayLen(int target, int[] nums) {

		int sum = 0;
		int start = 0;
		int end = 0;
		int minlen = 100001;
		// till end reaches last index of nums array
		// 2, 3, 1, 2, 4, 5
		// 0  1  2  3  4  5
		//                i
		//                j
		while (end < nums.length) {
			sum = sum + nums[end];

			while (sum >= target) {
				minlen = Math.min(minlen, (end - start + 1));
				sum = sum - nums[start++];
			}

			end++;
		}

		return (minlen == 100001) ? 0 : minlen;

	}

	public static int minSubArrayLen_Brute(int target, int[] nums) {

		// brute force : Time limit will exceed
		// Time Complexity : O(n^2)
		// Space Complexity : O(n)
		int sum = 0;
		int minLen = 100001;

		// 1, 1, 1, 1, 1, 1, 1, 1
		// 0 1 2 3 4 5 6 7 index
		// i
		// j
		for (int i = 0; i < nums.length; i++) {

			for (int j = i; j < nums.length; j++) {
				sum = sum + nums[j];
				if (sum >= target) {
					minLen = Math.min(minLen, (j - i + 1));

					break;
				}
				sum = 0;
			}
		}
		return (minLen == 100001) ? 0 : minLen;
	}
}
