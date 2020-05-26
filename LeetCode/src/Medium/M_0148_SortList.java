package Medium;
import Helper.LinkListNode;
/*
 * http://www.programcreek.com/2012/11/leetcode-solution-merge-sort-linkedlist-in-java/
 * https://leetcode.com/problems/sort-list/
 * SLL_034: http://www.geeksforgeeks.org/merge-sort-for-linked-list/
 */
public class M_0148_SortList {

	public static LinkListNode sortList(LinkListNode head){
		if(head == null || head.next == null) return head;
		int size = 0;
		LinkListNode temp = head;
		// Finding list size
		while(temp != null){
			size++;
			temp = temp.next;
		}
		int mid = size/2;
		LinkListNode left = head;
		LinkListNode right = null;
		int  i = 0;
		temp = head;
		// Break list in 2 parts left and right
		while(temp != null){
			i++;
			LinkListNode next = temp.next;
			if(i == mid){
				temp.next = null;
				right = next;
			}
			temp = next;
		}
		LinkListNode h1 = sortList(left);
		LinkListNode h2 = sortList(right);
		LinkListNode merged = merge(h1,h2);
		return merged;
	}

	public static LinkListNode merge(LinkListNode leftList, LinkListNode rightList){

		LinkListNode newList = new LinkListNode(100);
		LinkListNode newPtr = newList;
		while(leftList != null || rightList != null){
			if(leftList == null){
				newPtr.next = new LinkListNode(rightList.val);
				rightList = rightList.next;
				newPtr = newPtr.next;
			}
			else if(rightList == null){
				newPtr.next = new LinkListNode(leftList.val);
				leftList = leftList.next;
				newPtr = newPtr.next;
			}
			else{
				if(leftList.val < rightList.val){
					newPtr.next = new LinkListNode(leftList.val);
					leftList = leftList.next;
					newPtr = newPtr.next;
				}
				else if(leftList.val > rightList.val){
					newPtr.next = new LinkListNode(rightList.val);
					rightList = rightList.next;
					newPtr = newPtr.next;
				}
				else if(leftList.val == rightList.val){
					newPtr.next = new LinkListNode(rightList.val);
					rightList = rightList.next;
					newPtr = newPtr.next;
					newPtr.next = new LinkListNode(leftList.val);
					leftList = leftList.next;
					newPtr = newPtr.next;
				}
			}
		}
		return newList.next;
	}

	public static void printList(LinkListNode x) {
		if(x != null){
			System.out.print(x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}
 
	}
	
	public static void main(String[] args) {	
		M_0148_SortList obj = new M_0148_SortList();
		
		LinkListNode n1 = new LinkListNode(4);
		LinkListNode n2 = new LinkListNode(2);
		LinkListNode n3 = new LinkListNode(1);
 
		LinkListNode n4 = new LinkListNode(3);
 
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		System.out.println("Before");
 		printList(n1);
		n1 = obj.sortList(n1);
 		System.out.println("After");
		printList(n1);
	}

}
