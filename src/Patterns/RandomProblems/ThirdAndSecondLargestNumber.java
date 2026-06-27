package Patterns.RandomProblems;

public class ThirdAndSecondLargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr [] = {12, 35, 1, 10, 34, 13};
		//System.out.println(secondLargestNumber(arr));
		
		System.out.println(thirdLargestNumber(arr));

	}

	public static int secondLargestNumber(int[] arr) {

		int largest = arr[0];
		int secondLargest = -1;

		int c = 1;
		while (c < arr.length) {

			// condition1
			if (arr[c] < largest && arr[c] > secondLargest) {
				secondLargest = arr[c];
			}

			// condition2
			else if (arr[c] > largest) {
				secondLargest = largest;
				largest = arr[c];
			}
			c++;

		}

		return secondLargest;
	}

	
	public static int thirdLargestNumber(int [] arr) {
		
		int largest = arr[0];
		int secondLargest = -1;
		int thirdLargest = -1;
		
		int c = 1;
		
		while(c < arr.length) {
			
			//conidtion1 => koi number largest bhi bada hai, so u got your second largest
			if(arr[c] > largest) {
				secondLargest = largest;
				largest = arr[c];
			}
			
			//condition2
			else if(arr[c] < largest && arr[c] > secondLargest && secondLargest > thirdLargest) {
				thirdLargest = secondLargest;
				secondLargest = arr[c];
			}
			
			//conidtion3
			else if(arr[c] < largest && arr[c] < secondLargest && arr[c] > thirdLargest) {
				thirdLargest = arr[c];
			}
			c++;
		}
		
		
		return thirdLargest;
	}
}
