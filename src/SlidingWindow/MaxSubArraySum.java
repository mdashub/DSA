package SlidingWindow;

public class MaxSubArraySum {

	public static void main(String[] args) {

		int[] arr = { 100, 200, 300, 400 };
		int k =2;
		System.out.println(maxSubarraySum(arr, k));
	}

	public static int maxSubarraySum(int[] arr, int k) {

		int start = 0;
		int end = 0;
		int sum = 0;
		int i = 0;
		for (; i < k; i++) {
			sum = sum + arr[i];
		}
		end = i ;
		int maxSum = sum;

		while (end < arr.length) {
			sum = sum - arr[start];
			sum = sum + arr[end];

			maxSum = (maxSum < sum) ? sum : maxSum;
			start++;
			end++;

		}
		return maxSum;
	}
}
