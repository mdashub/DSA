package Patterns.TwoPointers;

public class DutchNationalFlag {

	public static void main(String[] args) {

		int nums[] = { 2,0,1};
		sortColors(nums);
	}

	public static void sortColors(int[] nums) {

		int start = 0;
		int cursor = 0; // this will be iterating
		int end = nums.length - 1;

		// cursor value = 0 (swap with start)
		// cursor value = 1 (cursor++ don't do anything)
		// cursor value = 2 (swap with end)

		while (cursor <= end) {

			if (nums[cursor] == 0)
				swap(nums, cursor++, start++);
			else if (nums[cursor] == 2)
				swap(nums, cursor, end--);
			else
				cursor++;
		}

	}

	public static void swap(int nums[], int i, int j) {

		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
