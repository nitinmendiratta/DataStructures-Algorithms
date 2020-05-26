package LinkList;
import java.util.Scanner;
/*
 * http://www.geeksforgeeks.org/flattening-a-linked-list/
 */
public class SLL_045_FlattenLL {
	
	public ListNode flatten(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode result = null;
		ListNode current = head;
		ListNode runner = current.next;
		while(runner != null){
			current = merge(current,runner);
			runner = runner.next;
		}
		return current;
	}
		
	public ListNode merge(ListNode a, ListNode b){
		ListNode result = null;
		if(a == null && b == null) return null;
		else if(a == null) return b;
		else if(b == null) return a;
		else{
			while(a != null && b != null){
				if(a.data == b.data){
					result = addNodeAtEnd(result,a.data);
					a = a.down;
					b = b.down;
				}else if(a.data < b.data){
					result = addNodeAtEnd(result,a.data);
					a = a.down;
				}else{
					result = addNodeAtEnd(result,b.data);
					b = b.down;
				}
			}
			if(a != null){
				while(a != null){
					result = addNodeAtEnd(result,a.data);
					a = a.down;
				}
			}else if(b != null){
				while(b != null){
					result = addNodeAtEnd(result,b.data);
					b = b.down;
				}
			}
		}
		return result;
	}
	
	public ListNode createDownLL(){
		ListNode head = null;
		System.out.println("Enter number of elements u wanna have in your linklist.");
		Scanner in =new Scanner(System.in);
		int n = in.nextInt();
		int input;
		System.out.println("Enter "+n+" elements.");
		for(int i = 0;i < n;i++){
			in = new Scanner(System.in);
			input = in.nextInt();
			head = addNodeAtEnd(head,input);
		}
		return head;
	}
	
	public ListNode addNodeAtEnd(ListNode head, int data){
		ListNode newNode = new ListNode(data);
		ListNode ptr = head;
		if(head == null){
			newNode.down = head;
			head = newNode;
			return head;
		}
		else{
			while(ptr.down != null) ptr = ptr.down;
			ptr.down = newNode;
			return head;
		}
	}
	
	public void printDownLinkList(ListNode head){
		ListNode ptr = head;
		if(head == null) System.out.println("List is empty");
		while(ptr != null){
			System.out.print(ptr.data+"->");
			ptr = ptr.down;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		SLL_045_FlattenLL obj = new SLL_045_FlattenLL();
		//LinkListOperations ll = new LinkListOperations();
		ListNode head1 = null;
		head1 = obj.createDownLL();
		obj.printDownLinkList(head1);
		head1.next = obj.createDownLL();
		obj.printDownLinkList(head1.next);
        head1.next.next = obj.createDownLL();
        obj.printDownLinkList(head1.next.next);
        head1.next.next.next = obj.createDownLL();
        obj.printDownLinkList(head1.next.next.next);
        ListNode head = null;
        head = obj.flatten(head1);
        System.out.println("Flatten List is:");
        obj.printDownLinkList(head);
	}
}
