package Helper;

import java.util.Scanner;
//createLinkList
//createCLL
//createFullCLL
//addNodeAtBegining
//addNodeAtEnd
//addNodeAtNthPosition
//deleteNodeAtNthPosition
//deleteNodeFromEnd
//deleteNodeFromBeginning
//mergeLL
//printLinkList
//printCLL
//printLinkListUsingRecursion
//reverseLinkList
public class LinkListNode{
    public int val;
    public LinkListNode next;
    public LinkListNode prev;
    public LinkListNode down;
    public LinkListNode random;
    public LinkListNode(int val){
        this.val = val;
        this.next = null;
        this.prev = null;
        this.down = null;
        this.random = null;
    }
    
    public static void main(String[] args){
		LinkListNode head = null;
		printLinkList(head);
		head = addNodeAtBegining(head,4);
		printLinkList(head);
		head = addNodeAtBegining(head,3);
		printLinkList(head);
		head = addNodeAtBegining(head,2);
		printLinkList(head);
		head = addNodeAtBegining(head,1);
		printLinkList(head);
		head = addNodeAtEnd(head,5);
		printLinkList(head);
		head = addNodeAtEnd(head,6);
		printLinkList(head);
		head = addNodeAtNthPosition(head,7,7);
		printLinkList(head);
		head = deleteNodeAtNthPosition(head,7);
		printLinkListUsingRecursion(head);
	}

	public static LinkListNode createLinkList(){
		LinkListNode head = null;
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

	public static LinkListNode createCLL(){
		LinkListNode head = null;
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
		LinkListNode ptr = head;
		while(ptr.next != null){
			ptr = ptr.next;
		}
		ptr.next = head.next.next;
		return head;
	}

	public static LinkListNode createFullCLL(){
		LinkListNode head = null;
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
		LinkListNode ptr = head;
		while(ptr.next != null){
			ptr = ptr.next;
		}
		ptr.next = head;
		return head;
	}

	public static LinkListNode addNodeAtBegining(LinkListNode head, int val){
		LinkListNode newNode = new LinkListNode(val);
		newNode.next = head;
		head = newNode;
		return head;
	}

	public static LinkListNode addNodeAtEnd(LinkListNode head, int val){
		LinkListNode newNode = new LinkListNode(val);
		LinkListNode ptr = head;
		if(head == null){
			return newNode;
		}
		else{
			while(ptr.next != null) ptr = ptr.next;
			ptr.next = newNode;
			return head;
		}
	}

	//inserting nodes on a one based index LL
	public static LinkListNode addNodeAtNthPosition(LinkListNode head, int val, int pos) {
		LinkListNode newNode = new LinkListNode(val);
		LinkListNode ptr = head;
		int n = 1;
		while(ptr != null){
			n++;
			ptr = ptr.next;
		}
		if(pos > (n+2)){
			System.out.println("Enter a valid index");
			return head;
		}

		if(head == null){
			head = newNode;
			return head;
		}
		ptr = head;
		for(int i = 1;i <= pos-2;i++) ptr = ptr.next;
		newNode.next = ptr.next;     
		ptr.next = newNode;
		return head;
	}

	public static LinkListNode deleteNodeAtNthPosition(LinkListNode head,int pos){
		int n = 0;
		LinkListNode ptr = head;
		if(head == null){
			System.out.println("No element to delete");
			return head;
		}
		while(ptr.next != null){
			n++;
			ptr=ptr.next;
		}
		if(pos < n){
			System.out.println("Enter a valid index");
			return head;
		}
		if(pos == 1){
			head = ptr.next;
			return head;
		} 
		ptr = head;
		for(int i = 1;i <= pos-2;i++) ptr = ptr.next;
		ptr.next = (ptr.next).next;
		return head;
	}

	public static LinkListNode deleteNodeFromEnd(LinkListNode head){
		int n = 0;
		LinkListNode ptr = head;
		if(head == null){
			System.out.println("No element to delete");
			return head;
		}
		while(ptr.next != null){
			n++;
			ptr=ptr.next;
		}
		ptr = head;
		for(int i = 1;i <= n-2;i++) ptr = ptr.next;
		ptr.next = (ptr.next).next;
		return head;
	}

	public static LinkListNode deleteNodeFromBeginning(LinkListNode head){
		LinkListNode ptr = head;
		if(head == null){
			System.out.println("No element to delete");
			return head;
		}
		head = ptr.next;
		return head;
	}

	public static LinkListNode mergeLL(LinkListNode a, LinkListNode b){
		LinkListNode ptr = a;
		if(a == null && b == null) return null;
		else if(a == null) return b;
		else if(b == null) return a;
		else{
			while(ptr.next != null){
				ptr = ptr.next;
			}
			ptr.next = b;
		}
		return a;
	}

	public static void printLinkList(LinkListNode head){
		LinkListNode ptr = head;
		if(head == null) System.out.println("List is empty");
		while(ptr != null){
			System.out.print(ptr.val+"->");
			ptr = ptr.next;
		}
		System.out.println();
	}

	public static void printCLL(LinkListNode head){
		LinkListNode ptr = head;
	}
	public static void printLinkListUsingRecursion(LinkListNode ptr){
		if(ptr == null){
			System.out.println();
			return;
		}
		System.out.print(ptr.val+"->");
		printLinkListUsingRecursion(ptr.next);
	}

	public static LinkListNode reverseLinkList(LinkListNode currentPtr){
		if(currentPtr.next == null){
			return currentPtr;
		}
		LinkListNode ptr = reverseLinkList(currentPtr.next); 
		LinkListNode nextPtr = currentPtr.next;
		nextPtr.next = currentPtr;
		currentPtr.next = null;
		return ptr;
	}
	
	public static LinkListNode reverseLinkListIterative(LinkListNode head) {
		LinkListNode prev = null;
		LinkListNode cur = head;
		while (cur != null) {
			LinkListNode ptr = cur.next;
			cur.next = prev;
			prev = cur;
			cur = ptr;
		}
		return prev;
	}
}
