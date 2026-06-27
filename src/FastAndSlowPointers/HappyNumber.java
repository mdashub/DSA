package FastAndSlowPointers;

import java.util.ArrayList;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 10;
		System.out.println(isHappy1(n));
	}

	public static boolean isHappy(int n) {

		ArrayList<Integer> alist = new ArrayList<>();

		// get the digits
		int digits = 0;
		int sum = 0;
		int digitsToBeProcessed = 0;
		while (!(sum == 1 && digitsToBeProcessed == 0)) {

			digits = n % 10;
			sum += digits * digits;

			n = n / 10;
			digitsToBeProcessed = n;

			if (n == 0) {
				if (!alist.contains(sum))
					alist.add(sum);
				else
					return false;
				n = sum;
				if (sum != 1)
					sum = 0;
			}

		}

		return sum == 1 ? true : false;
	}

	// slow and fast pointer approach
	public static boolean isHappy1(int n) {

		int slow = n;
		int fast = n;

		while (fast != 1) {

			slow = helper(slow); // slow 1 operation
			fast = helper(helper(fast)); // fast 2 operation
			if (fast != 1 && slow == fast)
				return false; // cycle never ending
		}

		return true;

	}

	public static int helper(int nums) {
		int digits = 0;
		int sum = 0;
		int digitsToBeProcessed = 1; // assumptions
		while (digitsToBeProcessed != 0) {
			digits = nums % 10; // reminder
			sum = sum + (digits * digits);
			nums = nums / 10;
			digitsToBeProcessed = nums;
		}

		return sum;
	}

}
