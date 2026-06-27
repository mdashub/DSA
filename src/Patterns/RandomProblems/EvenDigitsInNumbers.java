package Patterns.RandomProblems;

public class EvenDigitsInNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 12, 345, 2, 6, 7896 };
		System.out.println(findNumbers(nums));
	}

	public static int findNumbers(int[] nums) {

		int ans = 0;
		// counter to track digits
		for (int x : nums) {

			// find digits in the number
			int n = x;
			int digits = 0;
			while (n != 0) {

				// divide operator
				n = n / 10;
				digits++;
			}

			// check for even
			ans = (digits % 2 == 0) ? ++ans : ans;
		}

		return ans;
	}

}
