package Easy;

import Helper.LinkListNode;

/*
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class E_0160_IntersectionOfTwoLinkedLists {

	public LinkListNode getIntersectionNode(LinkListNode a, LinkListNode b) {
		if(a == null || b == null) return null;
		LinkListNode aptr = a;
		LinkListNode bptr = b;
		int len1 = 0,len2 = 0;

		while(aptr != null){
			aptr = aptr.next;
			len1++;	
		}

		while(bptr != null){
			bptr = bptr.next;
			len2++;	
		}
		int diff = Math.abs(len1-len2);
		aptr = a;
		bptr = b;
		if(len1 > len2){
			while(diff > 0){
				aptr = aptr.next;
				diff--;
			}
		}
		else if(len2 > len1){
			while(diff > 0){
				bptr = bptr.next;
				diff--;
			}
		}

		while(aptr != null && bptr != null){
			if(aptr == bptr) return aptr;
			aptr = aptr.next;
			bptr = bptr.next;
		}
		return null;
	}

	public static void main(String[] args) {
		E_0160_IntersectionOfTwoLinkedLists obj = new E_0160_IntersectionOfTwoLinkedLists();
		LinkListNode head1 = null, head2 = null;
		LinkListNode temp[] = new LinkListNode[7];

		for(int i=0;i<7;i++)	temp[i] = new LinkListNode(0);
		// 4->6->7->1->null
		// 9->3->5->7
		temp[0].val = 4;
		temp[0].next = temp[1];
		temp[1].val = 6;
		temp[1].next = temp[2];
		temp[2].val = 7;
		temp[2].next = temp[3];
		temp[3].val = 1;
		temp[3].next = null;
		temp[4].val = 9;
		temp[4].next = temp[5];
		temp[5].val = 3;
		temp[5].next = temp[6];
		temp[6].val = 5;
		//temp[6].next = temp[2];

		head1 = temp[0];
		head2 = temp[4];
		LinkListNode result = obj.getIntersectionNode(head1,head2);
		if(result != null)System.out.println("merge point is at:"+result.val);
	}
}
