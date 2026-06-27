package FastAndSlowPointers;

public class Node3 {
	int data;
	Node3 next;

	Node3(int d) {
		data = d;
		next = null;
	}

}

class Solution4{
	public Pairs<Node3, Node3> splitList(Node3 head) {
		// Code here
		Node3 slow = head;
		Node3 fast = slow.next;

		while ((fast.next != head)) {

			// move slow by 1 unit
			slow = slow.next;

			int counter = 0;
			// move fast by 2 unit
			while (fast.next != head && counter != 2) {
				fast = fast.next;
				counter += 1;
			}
		}

		Node3 secondHead = slow.next;
		fast.next = secondHead;
		slow.next = head;
		// put in a return type basket
		return new Pairs<Node3, Node3>(head, secondHead);
	}
}