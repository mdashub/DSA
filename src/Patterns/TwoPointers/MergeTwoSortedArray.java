package Patterns.TwoPointers;

public class MergeTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums1 = { 0 };
		int m = 0;
		int[] nums2 = { 1 };
		int n = 1;

		merge(nums1, m, nums2, n);
	}

	
	//dont use extra space, modify the nums1 array
	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		int i = m - 1;
		int j = n - 1;
		int k = nums1.length - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] < nums2[j])
				// k get value stored
				nums1[k--] = nums2[j--];
			else
				nums1[k--] = nums1[i--];

		}
		if (j >= 0) {
			while (k >= 0 && j >= 0) {
				nums1[k--] = nums2[j--];
			}

		}
	}

}
