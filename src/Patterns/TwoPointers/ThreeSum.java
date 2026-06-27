package Patterns.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = { -2, -2, -2, 0, 0, 0, -1, -1, -1, 2, 2, 2, 2 };
		System.out.println(threeSum(nums));

	}

	public static List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);
		int startPointer = 0;

		List<List<Integer>> ansList = new ArrayList<List<Integer>>();

		while (startPointer <= nums.length - 3) {
			int i = startPointer + 1;
			int j = nums.length - 1;

			while (i < j) {

				if (nums[startPointer] + nums[i] + nums[j] > 0)
					j--;

				else if (nums[startPointer] + nums[i] + nums[j] < 0)
					i++;

				else {
					List<Integer> pairs = new ArrayList<Integer>();
					pairs.add(nums[startPointer]);
					pairs.add(nums[i++]);
					pairs.add(nums[j--]);
					ansList.add(pairs);
					while (nums[j] == nums[j + 1] && i < j) {
						j--;
					}
					while (nums[i] == nums[i - 1] && i < j) {
						i++;
					}

				}

			}
			startPointer++;
			while (nums[startPointer] == nums[startPointer - 1] && startPointer <= nums.length - 3) {
				startPointer++;
			}
		}

		return ansList;
	}

}
