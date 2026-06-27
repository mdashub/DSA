package FastAndSlowPointers;


	

public class Node2{
    int data;
    Node2 next;

    Node2(int x) {
        data = x;
        next = null;
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub

    }

    public int lengthOfLoop(Node2 head) {
        // code here
        Node2 slow = head;
        Node2 fast = head;
        
        //check if cycle is there
        while(fast!=null && fast.next!=null){
            
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow==fast) //cycle is there => true
            {
                //find the entry point of cycle
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                
                //get the loop length
                slow = slow.next;
                int counter = 1;
                while(slow.next!=fast){
                 slow = slow.next;
                 counter+=1;
                }
                return counter+1;
            }
        }
        
        return 0; //if no cycle => no size 
    }
}
