package Patterns.RandomProblems;

public class PivotIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num[] = { 1, 2, 3 };
		System.out.println(pivotIndex(num));

	}

	public static int pivotIndex(int[] nums) {

		//find total sum = rsum
		int pivotIndex = 0;
		int lsum = 0;
		int rsum = 0;
		for (int x : nums) {
			rsum += x;
		}

		//check lsum = rsum
		while (pivotIndex < nums.length) {
			rsum = rsum - nums[pivotIndex];

			if (lsum == rsum)
				return pivotIndex;
			else
				lsum += nums[pivotIndex];

			pivotIndex++;

		}

		return -1;
	}

}
