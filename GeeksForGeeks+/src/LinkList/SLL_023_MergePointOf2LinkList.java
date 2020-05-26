package LinkList;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
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
 * both the pointers obyo and they will eventually meet at the merge point.
 */
public class SLL_023_MergePointOf2LinkList{
    
    //finds the intersection of the given linked lists version1 Brute force approach
    public ListNode mergePointApproach1(ListNode A, ListNode B){
        ListNode ptr1 = A;
        ListNode ptr2 = B;
        while(ptr1 != null){
          ptr2 = B;  
            while(ptr2 != null){
                if(ptr1 == ptr2) return ptr1;
                ptr2 = ptr2.next;
            }
            ptr1 = ptr1.next;
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
    
    public int length(ListNode head){
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        } 
        return len;
    }
    //finds the intersection of the given linked lists version3
    //The best approach to solve.
    public ListNode mergePointApproach3(ListNode A, ListNode B){
    	if(A == null || B == null) return null;
        ListNode ptr1 = A;
        ListNode ptr2 = B;
        int d = -1;
        int m = length(ptr1);//O(m)
        int n = length(ptr2);//O(n)
        
        if(m > n){
            d = m - n;
            ListNode temp = ptr1;
            ptr1 = ptr2;
            ptr2 = temp;
        }
        else d = n - m;

        for(int i=0;i<d;i++) ptr2 = ptr2.next;
    
        while(ptr1 != null && ptr2 !=null){
            if(ptr2 == ptr1) return ptr1;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return null;
    }
    
    public static void main(String[] args){
        // Code to test the logic, creating 7 nodes and linking them together as
        // two linked list merging at a point.
        SLL_023_MergePointOf2LinkList mergePoint = new SLL_023_MergePointOf2LinkList();
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
        ListNode result = mergePoint.mergePointApproach1(head1,head2);
        if(result != null)System.out.println("merge point with approach 1 is at:"+result.data);
        result = mergePoint.mergePointApproach2(head1,head2);
        if(result != null)System.out.println("merge point with approach 2 is at:"+result.data);
        result = mergePoint.mergePointApproach3(head1,head2);
        if(result != null)System.out.println("merge point with approach 3 is at:"+result.data);
    }
}
