package SlidingWindow;

public class MaximumAverageSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static double findMaxAverage(int[] nums, int k) {
		// 0 1   2  3 4  5
		// 1 12 -5 -6 50 3
		//           i
		//k=4
		double sum = 0d;
		double max = 0d;
		
		for (int i = 0; i < Math.min(k, nums.length); i++) {
			
			sum = sum + nums[i];
			
		}
		max=sum;
		
		
		// 0 1   2  3 4  5
		// 1 12 -5 -6 50 3
		//            i
		//k=4
		
		for(int i = k; i<nums.length ; i++) {
			 sum = sum + nums[i];
			 
			 sum = sum - nums[i-k];
			 
			 max = Math.max(sum, max);
			 
		}
	

		return max/k;
	}
}
