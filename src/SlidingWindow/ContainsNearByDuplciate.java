package SlidingWindow;

import java.util.HashMap;

public class ContainsNearByDuplciate {

	public static void main(String[] args) {

		int num[] = { 1, 0, 1, 1 };
		int k = 1;
		System.out.println(containsNearbyDuplicate(num, k));
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		// 0 1 2 3 4 5 index
		// 1, 0, 1, 1 array
		// i
		//

		HashMap<Integer, Integer> hmap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {

			if (!hmap.containsKey(nums[i])) {
				hmap.put(nums[i], i);

			} else {
				int j = hmap.get(nums[i]); //old index or
				if (i - j <= k) // current - old index
					return true;
				hmap.put(nums[i], i); // update current 

			}
		}
		return false;
	}
}
