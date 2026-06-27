package Patterns.TwoPointers;

public class SquaresOfSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {-4,-1,1,3,10};
		sortedSquares(nums);
	}

	public static int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];    
        int start =0;
        int end  = nums.length-1;
        int ans_pointer = ans.length-1;
        
        while(start<=end) {
             	
        	ans[ans_pointer--] = (nums[start]*nums[start] > nums[end]* nums[end])?nums[start]*nums[start++]:nums[end]*nums[end--];
        }
        return ans;

    }

}
