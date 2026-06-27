package FastAndSlowPointers;

import java.util.HashMap;

public class ListNode1 {

	int val;
	ListNode next;

	ListNode1(int x) {
		val = x;
		next = null;
	}
}

class Solution2 {
	public boolean hasCycle(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) { // fast moves 2 position so for safety
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
				return true;
		}
		return false;
	}

}

class Solution3 {
	public ListNode detectCycle(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;

		// to detect cycle exists/
		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			// cycle detected
			if (slow == fast) {
				slow = head; // slow or fast can be moved to start
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return fast; // entry point when slow == fast
			}
		}

		return null;
	}
}