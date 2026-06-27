package Patterns.RandomProblems;

import java.util.Stack;

public class ReverseALinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * This only changes the data stored in the linked list. Not the links example 5
	 * -> 7 -> 9 -> 8 -> 2 -> 1
	 * 
	 * after reverse with this code 1 -> 2 -> 8 -> 9 -> 7 -> 5
	 */
	public ListNode reverseList(ListNode head) {

		// using an extra space to store all elements in stack.
		Stack<ListNode> stack = new Stack<>();
		ListNode temp = head;
		while (temp != null) {
			if (!stack.contains(temp))
				stack.push(temp);
			temp = temp.next;
		}

		// take out all the elements from the stack and reverse
		temp = head;
		while (stack.size() != 0) {
			temp = stack.pop();
			temp = temp.next;

		}

		return null;
	}


	/*
	 * This changes the linked list pointers not the data 
	 * 
	 * example 
	 *   1 -> 3 -> 2 -> 5 -> null
	 *   ^
	 *  head
	 * ------------------------------------
	 * after reversing 
	 * 
	 * null <- 1 <- 3 <- 2 <- 5 
	 * 						  ^
	 * 						 head
	 * 
	 *   5 -> 2 -> 3 -> 1 -> null
	 * 	 ^
	 *  head
	 * 
	 */

	public ListNode reverseListCorrect(ListNode head) {

		ListNode prev = null;
		ListNode cursor = head;
		while (cursor != null) {

			ListNode front = cursor.next;
			cursor.next = prev;
			prev = cursor;
			cursor = front;
		}
		return prev;

	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}