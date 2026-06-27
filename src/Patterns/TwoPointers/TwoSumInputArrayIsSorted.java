package Patterns.TwoPointers;

public class TwoSumInputArrayIsSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 2, 7, 11, 15 };
		int target = 9;
		System.out.println(twoSum(nums, target));
	}

	public static int[] twoSum(int[] numbers, int target) {

		int ans[] = new int[2];

		int start = 0;
		int end = numbers.length - 1;

		while (start < end) {

			if (numbers[start] + numbers[end] < target)
				start++;
			else if (numbers[start] + numbers[end] > target)
				end--;
			else {
				ans[0] = start;
				ans[1] = end;
				break;
			}

		}

		return ans;
	}

}
