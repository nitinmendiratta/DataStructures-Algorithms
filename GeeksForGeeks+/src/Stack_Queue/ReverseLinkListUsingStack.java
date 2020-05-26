package Stack_Queue;
import java.util.*;
import LinkList.LinkListOperations;
import LinkList.ListNode;

public class ReverseLinkListUsingStack{
    public static void main(String[] args){
        LinkListOperations ll = new LinkListOperations();
        ListNode top = ll.createLinkList();
        ListNode ptr = top;
        int n = 1;
        while(ptr != null){
            n++;
            ptr = ptr.next;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ptr = top;
        while(ptr != null){
            stack.push(ptr);
            ptr = ptr.next;
        }
        ptr = stack.peek();
        top = ptr;
        stack.pop();
        System.out.println("Reverse Link List is:");
        while(!stack.isEmpty()){
            ptr.next = stack.pop();
            ptr = ptr.next;
        }
        ptr.next = null;
        ll.printLinkList(top);
    }
}
