package LinkList;
/*
 * In this program I have taken 3 pointers prev,current,next in order to reverse the 
 * link list
 */
public class SLL_016b_ReverseLinkedList{
   
    public static ListNode reverseLinkListUsingIteration(ListNode head){
        ListNode currentPtr, prevPtr, nextPtr;
        currentPtr = head;
        prevPtr = null;
        
        //below implementation covers both corner cases too i.e if head=null
        //and if there is only one node.

        while(currentPtr != null){
            nextPtr = currentPtr.next;
            currentPtr.next = prevPtr;
            prevPtr = currentPtr;
            currentPtr = nextPtr;
        }
        head = prevPtr;
        return head;
    }

    public static ListNode reverseLinkListUsingRecursion(ListNode currentPtr){
    	if(currentPtr == null) return null;	
        if(currentPtr.next == null){
            return currentPtr;
        }
        ListNode ptr = reverseLinkListUsingRecursion(currentPtr.next); 
        currentPtr.next.next = currentPtr;
        currentPtr.next = null;
        return ptr;
    }
    
    public static void main(String[] args){
        ListNode head = null;
        LinkListOperations ll = new LinkListOperations();
        head = ll.createLinkList();
        ll.printLinkList(head);
        //head = reverseLinkListUsingIteration(head);
        //ll.printLinkList(head);
        head = reverseLinkListUsingRecursion(head);
        ll.printLinkList(head);
    }

}

