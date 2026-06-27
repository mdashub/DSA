package SlidingWindow;

public class NumberOfSubArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = { 2, 2, 2, 2, 5, 5, 5, 8 };
		int k = 3;
		int t = 4;
		System.out.println(numOfSubarray(nums, k, t));
	}

	public static int numOfSubarray(int[] arr, int k, int threshold) {

		int sum = 0;
		// sum till k
		for (int i = 0; i < k; i++) {
			sum = sum + arr[i];
		}
		int avg = sum / k;
		int countSubs = 0;

		if (avg >= threshold) {
			countSubs += 1;
		}

		// from k till end

		for (int end = k; end < arr.length; end++) {

			sum = sum + arr[end]; // add 
			sum = sum - arr[end - k]; //trim
			avg = sum / k;            //
			if (avg >= threshold) {

				countSubs += 1;
			}
		}

		return countSubs;
	}

	public static int numOfSubarrays2(int[] arr, int k, int threshold) {

		int start = 0;
		int end = 0;
		int sum = 0;
		int avg = 0;
		int countSub = 0;
		int limit = 0;

		while (end < arr.length) {

			// find sum
			sum = sum + arr[end];
			limit = end - start + 1; // find limit

			if (limit == k) { // limit == k => avg => subArray

				avg = sum / k;
				if (avg >= threshold)
					countSub++;

			}

			else if (limit > k) { // limit > k ==> trim the window ==> re-evaluate limit ==>

				sum = sum - arr[start++];
				limit = end - start + 1;
				if (limit == k) { // limit == k => avg => subArray

					avg = sum / k;
					if (avg >= threshold)
						countSub++;

				}

			}
			end++;

		}

		return countSub;
	}
}
