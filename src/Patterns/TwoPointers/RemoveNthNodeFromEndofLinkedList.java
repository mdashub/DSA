//package Patterns.TwoPointers;
//
//public class RemoveNthNodeFromEndofLinkedList {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//	
//	
//	/**
//	 * Definition for singly-linked list.
//	 * public class ListNode {
//	 *     int val;
//	 *     ListNode next;
//	 *     ListNode() {}
//	 *     ListNode(int val) { this.val = val; }
//	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//	 * }
//	 */
//
//	    public ListNode removeNthFromEnd(ListNode headz, int n) {
//
//
//	     //dummy node
//	     ListNode dummy_first = new ListNode(0);
//	     dummy.next = head;
//
//	     int len =0;
//	     ListNode l = head;
//	     while(l!=null){
//	        len = len +1;
//	        l = l.next;
//	     } 
//
//	     int d = len - n +1;
//	     ListNode prev = dummy, curr = head;
//	     int i =0;
//	     while(i< (d-1)){
//	        curr = curr.next;
//	        prev = prev.next;
//	        i = i+1;
//	     }
//	     prev.next = curr.next;
//	     return dummy.next;
//	    }
//	}
//}
