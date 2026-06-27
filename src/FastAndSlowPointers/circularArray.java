package FastAndSlowPointers;

import java.util.HashSet;
import java.util.Set;

public class circularArray {

	public static void main(String[] args) {
		// i
		int nums[] = { -1, -1, -1 };
		// c
		// n
		System.out.println(cir(nums));

	}

	/*
	 * 457. Circular Array Loop Solved Medium Topics premium lock icon Companies You
	 * are playing a game involving a circular array of non-zero integers nums. Each
	 * nums[i] denotes the number of indices forward/backward you must move if you
	 * are located at index i:
	 * 
	 * If nums[i] is positive, move nums[i] steps forward, and If nums[i] is
	 * negative, move abs(nums[i]) steps backward. Since the array is circular, you
	 * may assume that moving forward from the last element puts you on the first
	 * element, and moving backwards from the first element puts you on the last
	 * element.
	 * 
	 * A cycle in the array consists of a sequence of indices seq of length k where:
	 * 
	 * Following the movement rules above results in the repeating index sequence
	 * seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ... Every nums[seq[j]] is
	 * either all positive or all negative. k > 1 Return true if there is a cycle in
	 * nums, or false otherwise.
	 * 
	 * 
	 */

	/*
	 * T : O(n^2) S : O(n)
	 */
	public static boolean circularArrayLoop(int[] nums) {

		// checking all items in array
		for (int i = 0; i < nums.length; i++) {

			// find if the seq isPos or isNeg
			boolean isPos = seqSign(nums, i);

			Set<Integer> set = new HashSet<>();
			set.add(i); // adds the indexes

			int c = i;

			while (true) {

				// isPos = true
				if (isPos) {

					// find the next Index
					int nextIndex = moveForward(nums, c);

					// if the nextIndex seq is valid or not
					isPos = seqSign(nums, nextIndex);
					if (!isPos)
						break;

					// check if nextIndex exists in set && loop detected need to have a length > 1
					if (set.contains(nextIndex) && (nextIndex != c)) {

						return true;
					}
					// k == 1(invalid loop)
					else if (nextIndex == c)
						break;

					set.add(nextIndex);

					c = nextIndex;

				}

				// isPos = false
				else {

					// find the next Index
					int nextIndex = moveForward(nums, c);

					// if the nextIndex seq is valid or not
					isPos = seqSign(nums, nextIndex);
					if (isPos)
						break;

					// check if nextIndex exists in set && loop detected need to have a length > 1
					if (set.contains(nextIndex) && (nextIndex != c)) {

						return true;
					}
					// k == 1(invalid loop)
					else if (nextIndex == c)
						break;

					set.add(nextIndex);

					c = nextIndex;

				}
			}
		}

		return false;

	}

	public static boolean cir(int nums[]) {

		for (int i = 0; i < nums.length; i++) {
			int curr = i;
			int slow = curr;
			int fast = curr;
			boolean isPos = (nums[slow] > 0);

			do {

				if (isPos) {
					slow = moveForward(nums, slow);
					if (!seqSign(nums, slow))
						break;

					fast = moveForward(nums, fast);
					if (!seqSign(nums, fast))
						break;
					fast = moveForward(nums, fast);
					if (!seqSign(nums, fast))
						break;

					if (slow == fast) {
						int nextSlow = moveForward(nums, slow);
						if (nextSlow == slow)
							break;
						else
							return true;
					}

					
				}
				
				//  i
				// -1 , -1 , -1
				//            s
				//  f
				else {

					slow = moveForward(nums, slow);
					if (seqSign(nums, slow))
						break;

					fast = moveForward(nums, fast);
					if (seqSign(nums, fast))
						break;
					fast = moveForward(nums, fast);
					if (seqSign(nums, fast))
						break;

					if (slow == fast) {
						int nextSlow = moveForward(nums, slow);
						if (nextSlow == slow)
							break;
						else
							return true;
					}

				}

			} while (slow != fast);

		}

		return false;
	}

	public static int moveForward(int[] nums, int c) {

		int next = 0;
		// for positive seq
		if (nums[c] > 0) {
			next = (c + nums[c]) % nums.length;
		}

		// for negative seq
		else {
			int mod = nums[c] % nums.length;
			int forward = mod + nums.length;
			next = (forward + c) % nums.length;
		}

		return next;
	}

	public static boolean seqSign(int[] nums, int i) {

		boolean isPos = true;

		if (nums[i] > 0)
			return isPos;
		else
			isPos = false;

		return isPos;
	}

}
