package FastAndSlowPointers;

public class findDuplicate {

	public static void main(String[] args) {
		int nums[] = { 5,6,3,2,1,4,4};
		System.out.println(findDuplicate2(nums));

	}

	// without modifying the original array
	public static int findDuplicate2(int[] nums) {

		int slow = 0;
		int fast = 0;

		//place where they meet
		do {

			slow = nums[slow];
			fast = nums[nums[fast]];
			if (slow == fast)
				break;

		} while (slow != fast);

		
		//find the entry point of circular linked list : same template 
		int n1 = 0;
		int n2 = slow;

		while (n1 != n2) {
			n1 = nums[n1];
			n2 = nums[n2];
		}

		return n1;

	}

	// this approach modifies the original array
	public static int findDuplicate(int[] nums) {

		int cursor = 0;
		int value = 0;

		while (value >= 0) {

			value = nums[cursor];
			// mark it as visited
			if (value > 0) {
				nums[cursor] = (value * (-1));
			} else
				return cursor;
			cursor = value;

		}

		return 0;

	}

}
