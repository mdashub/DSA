package Patterns.RandomProblems;

public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] nums  = {1,1,0,1,1,1};
		System.out.println(maxConsecutive(nums));

	}

	public static int maxConsecutive(int[] nums) {

		// counter : to staore the counts of 1
		int counter = 0;

		// possible answer : to store the max counters
		int ans = 0;

		// iterating through the array
		for (int x : nums) {
			if (x == 1) {
				counter++;
			} else {
				ans = (ans < counter) ? counter : ans;
				counter = 0;
			}
		}

		return ans = (ans < counter) ? counter : ans;
	}

}
