package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntheBasket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
		System.out.println(totalFruit(nums));

	}

	public static int totalFruit(int[] fruits) {

		int start = 0;
		int end = 0;

		int maxFruits = 0;
		
		HashMap<Integer, Integer> hmap = new HashMap<>();

		while (end < fruits.length) {

			hmap.put(fruits[end], hmap.getOrDefault(fruits[end], 0) + 1); 

			//calculate the maxWindow  till window has 2 distinct elements
			if (hmap.size() <= 2) {
				maxFruits = Math.max(end-start+1, maxFruits);
			}

			else {
				//keep on removing the element till window has 2 distinct elements
				while (hmap.size() != 2) {
					int value =hmap.get(fruits[start]);
					hmap.put(fruits[start], value - 1);
					if (hmap.get(fruits[start]) == 0) {
						hmap.remove(fruits[start]);
					}
					start++;
				}
			}

			end++;
		}

		return maxFruits;
	}

}
