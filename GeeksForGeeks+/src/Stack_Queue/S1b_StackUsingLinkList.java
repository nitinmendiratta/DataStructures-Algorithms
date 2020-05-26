//package Stack_Queue;
//// http://quiz.geeksforgeeks.org/stack-set-1/
//
////import LinkList.LinkListOperations; // custom package provides basic operations on link list
////import LinkList.ListNode;;
///*
// * Here we implement stack using LL as in stack addition and deletion happens
// * in constant time so we need to have all operations on LL too in constant
// * time so we have added and deleted element from beginning in the LL.
// * Advantage of LL implementation is that we don't have to take care of underflow
// * condition. And the stack will not overflow unless memory is full.
// */
//public class S1b_StackUsingLinkList{
//
//    LinkListOperations ll = new LinkListOperations();
//    ListNode top;
//    public S1b_StackUsingLinkList(){
//        top = null;
//    }
//
//    public void push(long input){
//        top = ll.addNodeAtBegining(top,(int)input);
//    }
//  
//    public long pop(){
//        if(isEmpty()){
//            System.out.println("stack is empty");
//            throw new IllegalStateException();
//        }
//        long value = top.data;
//        top = ll.deleteNodeFromBeginning(top);
//        return value;
//    }
//
//    public boolean isEmpty(){
//        return (top == null);
//    }
//
//    public static void main(String[] args){
//        S1b_StackUsingLinkList stack = new S1b_StackUsingLinkList();
//        try{
//            stack.push(1);
//            stack.push(2);
//            stack.push(3);
//            stack.push(4);
//            stack.push(5);
//            while(!stack.isEmpty()){
//                long value = stack.pop();
//                System.out.println("popped elem is:"+value);
//            }
//            long value = stack.pop();
//        }
//        catch(IllegalStateException e){
//          System.out.println("Underflow/overflow Exception");
//        }
//    }
//}
