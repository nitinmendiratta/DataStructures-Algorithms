package LinkList;

/*
 * http://www.geeksforgeeks.org/split-a-circular-linked-list-into-two-halves/
 */
 
public class CLL_003_SplitCLLintoTwoHalves {

	public ListNode[] split(ListNode a){
		ListNode[] result = {null,null};
		if(a == null || a.next == null){
			result[0] = a;
			return result;
		}
		ListNode ptr = a;
		ListNode head1 = null;
		ListNode head2 = null;
		int count = 1;
		while(ptr != null){
			if(ptr.next == a) break;
			ptr = ptr.next;
			count++;
			
		}
		ptr.next = null;
		head1 = a;
		int len1 = count/2;
		while(len1 > 1){
			head1 = head1.next;
			len1--;
		}
		head2 = head1.next;
		head1.next = null;
		head1 = a;
		result[0] = head1;
		result[1] = head2;
		return result;
	}

	public static void main(String[] args) {
		CLL_003_SplitCLLintoTwoHalves obj = new CLL_003_SplitCLLintoTwoHalves();
		ListNode[] result = {null,null};
        LinkListOperations ll = new LinkListOperations();
        ListNode head = null;
        head = ll.createFullCLL();
        result = obj.split(head);
        ll.printLinkList(result[0]);
        ll.printLinkList(result[1]);
	}
}
