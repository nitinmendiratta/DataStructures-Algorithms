package LinkList;

import java.util.HashSet;
import java.util.Set;

/*
 * http://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
 * http://www.programcreek.com/2014/02/leetcode-intersection-of-two-linked-lists-java/
 * 
 * This problem can be solved by 3 approaches
 * Suppose we have linklist A with length m and linklist B with length n
 * 
 * Approach 1: Brute force
 * In this problem we can compare the first link list with each elem in the second and
 * where ever the elem matches is the merge point this wud give us complexity of O(mn)
 *
 * Approach 2:
 * In this we can follow a time memory trade off ie invest some memory to spare some execution time.
 * In this we can save all the addresses of B link list into a SET(set use BST and 
 * provide insertion and retrieval in log time) and compare all the elem of A linklist
 * with the set. 
 * Complexity: Insertion and deletion in set take log time and we are running the insertion statement for a set n times so complexity 
 * is nlogn and comparing takes mlogn time. So overall complexity is mlogn + nlogn and also exta space for set
 * 
 * Approach 3:
 * In this we can move the longer linklist by the diff(m-n) and then compare each element of both link list one by one incrementing 
 * both the pointers and they will eventually meet at the merge point.
 */
public class SLL_023_IntersectionPointOfTwoLinkedLists {

	//Time Complexity: O(m+n), Auxiliary Space: O(1)
	public ListNode getIntersectionNode(ListNode headA, ListNode headB){
		ListNode ptr1 = headA;
		ListNode ptr2 = headB;
		
		int len1 = 0;
		int len2 = 0;
		while(ptr1 != null){
			ptr1 = ptr1.next;
			len1++;
		}
		while(ptr2 != null){
			ptr2 = ptr2.next;
			len2++;
		}
		ptr1 = headA;
		ptr2 = headB;
		int diff = Math.abs(len1-len2);
		if(len1 > len2){
			int i = 0;
			while(i < diff){
				ptr1 = ptr1.next;
				i++;
			}
		}else if(len2 > len1){
			int j = 0;
			while(j < diff){
				ptr2 = ptr2.next;
				j++;
			}
		}else{
			System.out.println("No intersection found");
		}
		
		while(ptr1 != null && ptr2 != null){
			if(ptr1.data == ptr2.data){
				return ptr1;
			}
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		return null;
	}
	
	//finds the intersection of the given linked lists version2
    //Using memory in brute force Overall Complexity -> O(m log n + n log n)
    public ListNode mergePointApproach2(ListNode A, ListNode B){
    	ListNode ptr1 = A;
    	ListNode ptr2 = B;
        Set<ListNode> set = new HashSet<ListNode>();
        while(ptr2 != null){    //O(n log n)
            set.add(ptr2);  //O(log n)
            ptr2 = ptr2.next;
        }
        while(ptr1 != null){    //O(m log n)
            if(set.contains(ptr1)) return ptr1;
            ptr1 = ptr1.next;
        }
        return null;
    }
	public static void main(String[] args) {
        // Code to test the logic, creating 7 nodes and linking them together as
        // two linked list merging at a point.
		SLL_023_IntersectionPointOfTwoLinkedLists mergePoint = new SLL_023_IntersectionPointOfTwoLinkedLists();
        ListNode head1 = null, head2 = null;
        ListNode temp[] = new ListNode[7];
        for(int i=0;i<7;i++) {
            temp[i] = new ListNode(0);;
        }
        // 4->6->7->1->null
		// 9->3->5->7
        temp[0].data = 4;
        temp[0].next = temp[1];
        temp[1].data = 6;
        temp[1].next = temp[2];
        temp[2].data = 7;
        temp[2].next = temp[3];
        temp[3].data = 1;
        temp[3].next = null;
        temp[4].data = 9;
        temp[4].next = temp[5];
        temp[5].data = 3;
        temp[5].next = temp[6];
        temp[6].data = 5;
        temp[6].next = temp[2];
 
        head1 = temp[0];
        head2 = temp[4];
        ListNode result = mergePoint.mergePointApproach2(head1,head2);
        if(result != null)System.out.println("merge point with approach 1 is at:"+result.data);
        result = mergePoint.getIntersectionNode(head1,head2);
        if(result != null)System.out.println("merge point with approach 2 is at:"+result.data);
        
	}

}
