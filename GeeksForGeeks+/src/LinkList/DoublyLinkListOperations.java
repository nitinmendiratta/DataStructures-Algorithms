package LinkList;
import java.util.*;

public class DoublyLinkListOperations{

    public static void main(String[] args){
        ListNode head = null;
        printDll(head);
        head = addNodeAtBegining(head,4);
        printDll(head);
        head = addNodeAtBegining(head,3);
        printDll(head);
        head = addNodeAtBegining(head,2);
        printDll(head);
        head = addNodeAtBegining(head,1);
        printDll(head);
        head = addNodeAtEnd(head,5);
        printDll(head);
        head = addNodeAtEnd(head,6);
        printDll(head);
        printReverseDll(head);
        head = addNodeAtNthPosition(head,7,7);
        printReverseDll(head);
        printDll(head);
        /*head = addNodeAtNthPosition(head,10,5);
        printDll(head);
        head = deleteNodeAtNthPosition(head,5);
        printDll(head);
        printReverseDll(head);*/
        printDll(head);
        System.out.println("reversing");
        head = reverseDLL(head);
        printDll(head);
    }

    public static ListNode createDLL(){
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

    public static ListNode addNodeAtBegining(ListNode head, int data){
        ListNode newNode = new ListNode(data);
        ListNode ptr = head;
        if(head == null){
            head = newNode;
            return head;
        }
        newNode.next = ptr;
        ptr.prev = newNode;
        head = newNode;
        return head;
    }

    public static ListNode addNodeAtEnd(ListNode head, int data){
        ListNode newNode = new ListNode(data);
        ListNode ptr = head;
        if(head == null){
            head = newNode;
            return head;
        }
        while(ptr.next != null) ptr = ptr.next;
        ptr.next = newNode;
        newNode.prev = ptr;
        return head;
    }

    //inserting nodes on a 1 based index LL
    public static ListNode addNodeAtNthPosition(ListNode head, int data, int pos){
        ListNode newNode = new ListNode(data);
        ListNode ptr = head;
        int n = 1;
        while(ptr != null){
            n++;
            ptr = ptr.next;
        }
        if(pos > (n+2)){
           System.out.println("Enter a valid index as there are only:"+n+" elements in list");
           return head;
        }
        if(head == null){
            head = newNode;
            return head;
        }
        ptr = head;
        for(int i = 1;i < pos-1;i++) ptr = ptr.next;

        if(pos != n){
            newNode.next = ptr.next;
            ptr.next = newNode;
            newNode.prev = ptr;
            (ptr.next).prev = newNode;
            return head;
        }
        else{
            newNode.next = ptr.next;
            ptr.next = newNode;
            newNode.prev = ptr;
        }
        return head;
    }

    public static ListNode deleteNodeAtNthPosition(ListNode head,int pos){
        ListNode ptr = head;
        int n = 1;
        while(ptr != null){
            n++;
            ptr = ptr.next;
        }
        if(pos > n){
           System.out.println("Enter a valid index as there are only:"+n+" elements in list");
           return head;
        }
        if(head == null){
            System.out.println("List is empty nothing to delete");
            return head;
        }
        if(pos == 1){
            head = ptr.next;
            (ptr.next).prev = ptr.prev;
            return head;
        }
        //below loop takes u too pos-1
        ptr = head;
        for(int i = 1;i < pos-1;i++) ptr = ptr.next;
        if(pos != n){
            ptr.next = (ptr.next).next;
            ((ptr.next).next).prev = ptr;
            return head;
        }
        else if(pos == n){
            ptr.next = null;
            return head;
        }
        return head;
    }

    public static void printDll(ListNode head){
		ListNode ptr = head;
        if(head == null) System.out.println("List is empty");
        while(ptr != null){
			System.out.print(ptr.data+"->");
			ptr = ptr.next;
		}
		System.out.println();
	}

    public static void printDllUsingRecursion(ListNode ptr){
        if(ptr == null){
            System.out.println();
            return;
        }
	    System.out.print(ptr.data+"->");
		printDllUsingRecursion(ptr.next);
	}

    public static void printReverseDll(ListNode head){
		ListNode ptr = head;
        if(head == null) System.out.println("List is empty");
        while(ptr.next != null) ptr = ptr.next;
        while(ptr != null){
			System.out.print(ptr.data+"->");
			ptr = ptr.prev;
		}
		System.out.println();
	}
	
	public static ListNode reverseDLL(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode current = head;
		ListNode temp = null;
		while(current != null){
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}
		if(temp != null) head = temp.prev;
		return head;
	}
}

