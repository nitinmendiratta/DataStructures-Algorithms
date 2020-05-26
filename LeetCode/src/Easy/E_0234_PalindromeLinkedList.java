/* 
 * Function to check if a singly linked list is palindrome
 * SLL_022: http://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
 * http://www.programcreek.com/2014/07/leetcode-palindrome-linked-list-java/
 * https://leetcode.com/problems/palindrome-linked-list/
 */
package Easy;

import Helper.LinkListNode;
import Helper.LinkListNode;

// use a fast and slow pointer to get the center of the list, then reverse the second list and compare two sublists. 
//The time is O(n) and space is O(1)

public class E_0234_PalindromeLinkedList {

	public boolean isPalindrome(LinkListNode head) {
		if(head == null || head.next==null)
			return true;

		//find list center
		LinkListNode fast = head;
		LinkListNode slow = head;

		while(fast.next!=null && fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}

		LinkListNode secondHead = slow.next;
		slow.next = null;

		//compare two sublists now
		secondHead = reverseList(secondHead);
		LinkListNode start = head;
		while(secondHead != null){
			if(start.val != secondHead.val)
				return false;

			secondHead = secondHead.next;
			start = start.next;	 
		}	 
		return true;
	}
	public LinkListNode reverseList(LinkListNode head) {
		LinkListNode prev = null, curr = head;
		if(head == null || head.next == null){
			return head;
		}
		LinkListNode next = head.next;
		while(curr != null){
			curr.next = prev;
			prev = curr;
			curr = next;
			if(next != null){
				next = next.next;
			}
		}
		return prev;
	}


	public boolean isPalindromeApproach2(LinkListNode head){
		if(head == null || head.next==null)
			return true;

		//find list center
		LinkListNode fast = head;
		LinkListNode slow = head;

		while(fast.next!=null && fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}

		LinkListNode secondHead = slow.next;
		slow.next = null;

		//reverse second part of the list
		LinkListNode p1 = secondHead;
		LinkListNode p2 = p1.next;

		while(p1!=null && p2!=null){
			LinkListNode temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;
		}

		secondHead.next = null;

		//compare two sublists now
		LinkListNode p = (p2==null?p1:p2);
		LinkListNode q = head;
		while(p!=null){
			if(p.val != q.val)
				return false;

			p = p.next;
			q = q.next;	 
		}	 
		return true;
	}

	public static void main(String[] args) {
		E_0234_PalindromeLinkedList obj = new E_0234_PalindromeLinkedList();
		LinkListNode head = null;
		head = LinkListNode.createLinkList();
		LinkListNode.printLinkList(head);
		System.out.println(obj.isPalindrome(head));
	}
}
