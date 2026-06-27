package FastAndSlowPointers;



public class PalindromeLinkedList {

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
class Solution6 {
    public boolean isPalindrome(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;

    //unviersal condition of fast and slow pointers
      while(fast != null && fast.next != null ){

        //specfic for plaindrom case
        if(fast.next.next == null )
            break;
        else{
            slow= slow.next;
            fast = fast.next.next;
        }
      }

    //next node to be given to reverse  
    ListNode currsor = slow.next;
    slow.next=null; // listNode was cut off and it becomes list1 
    ListNode secondHead = reverseLinkedList(currsor); // lis2

    return checkPalindrome(head,secondHead);

    }

    public boolean checkPalindrome(ListNode head , ListNode secondHead){
        ListNode i = head ; 
        ListNode j = secondHead;
        while(i!= null && j!= null){
            if(i.val == j.val){ //check the values
                i = i.next;
                j = j.next;
            }
            else
            return false;
        }
        return true;
    }

    //to reverse a linked list
    public ListNode reverseLinkedList (ListNode head){

        ListNode currsor = head; 
        ListNode prev = null; 
        while(currsor!=null){
            ListNode front = currsor.next;
            currsor.next = prev;
            prev = currsor;
            currsor = front;
        }
        return prev;
    }
}