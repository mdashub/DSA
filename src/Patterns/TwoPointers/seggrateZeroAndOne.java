package Patterns.TwoPointers;

public class seggrateZeroAndOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 0, 0, 1, 0, 1, 0, 1, 1, 1 };
		seggerateOand1(nums);

	}

	public static void seggerateOand1(int[] arr) {

		int start = 0;
		int end = arr.length - 1;

		while (start < end) {

			if (arr[start] == 1) {
				swap(arr, start, end);
				end--;
			} else
				start++;

		}

	}

	public static void swap(int nums[], int start, int end) {

		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;

	}

}
