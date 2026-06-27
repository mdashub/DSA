package SlidingWindow;

import java.security.cert.CRLReason;
import java.util.Arrays;

public class FrequencyOfMostFrequentElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = { 1, 1,1,2,2,4 };
		int k = 2;
		// System.out.println(maxFrequency(nums, k));
		System.out.println(maximumFrquency(nums, k));

	}

	public static int maximumFrquency(int[] nums, int k) {

		// 1 1 1 2 2 4
		//         r
		//   l
		// t

		Arrays.sort(nums);
		long currentSum = 0;
		int l = 0;
		int r = 0;
		int maxFreq = 0;

		while (r < nums.length) {

			long target = nums[r];
			long windowSum = target * (r - l + 1);
			currentSum += nums[r];

			long ops = windowSum - currentSum;

			while (ops > k) {

				currentSum -= nums[l];
				l = l + 1;
				windowSum = target * (r - l + 1);
				ops = windowSum - currentSum;

			}

			maxFreq = Math.max(r - l + 1, maxFreq);
			r++;

		}

		return maxFreq;
	}

}
