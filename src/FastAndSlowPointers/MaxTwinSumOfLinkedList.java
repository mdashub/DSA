package FastAndSlowPointers;

public class MaxTwinSumOfLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution5 {
    public int pairSum(ListNode head) {
        
        //finding the node for splitting the linked list.
       ListNode slow = splittingLinkedList(head);

        //reverse the linked list.
        ListNode cursor = slow.next;
        slow.next = null; //cut-off list1
        ListNode secondHead = reverseLinkedList(cursor); 


        //finding the twin sums
        ListNode i = head;
        ListNode j = secondHead;
        int maxSum = 0 ;

        while(i!=null && j!=null){
            int sum = (i.val + j.val);
            maxSum = (maxSum < sum)? sum : maxSum;
            i = i.next;
            j = j.next;
        }
        return maxSum;
        
    }

    public ListNode splittingLinkedList(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next!=null){
            if(fast.next.next == null)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseLinkedList(ListNode head){
        ListNode prev = null; 
        ListNode temp = head;

        while(temp!=null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev; // head of second linked list
    }
}