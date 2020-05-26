package Stack_Queue;
/* 
 * http://www.geeksforgeeks.org/implement-lru-cache/
 * http://www.programcreek.com/2013/03/leetcode-lru-cache-java/

We use two data structures to implement an LRU Cache.

Queue which is implemented using a doubly linked list. 
The maximum size of the queue will be equal to the total number of frames available (cache size).
The most recently used pages will be near front end and least recently pages will be near rear end.

A Hash with page number as key and address of the corresponding queue node as value.
When a page is referenced, the required page may be in the memory. 
If it is in the memory, we need to detach the node of the list and bring it to the front of the queue.
If the required page is not in the memory, we bring that in memory. 
In simple words, we add a new node to the front of the queue and update the corresponding node address in the hash. 
If the queue is full, i.e. all the frames are full, we remove a node from the rear of queue, 
and add the new node to the front of queue.
*/
import java.util.HashMap;

class LRUNode{
    int key;
    int value;
    LRUNode pre;
    LRUNode next;
 
    public LRUNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}

public class Q16_LRUcache {

    int capacity;
    HashMap<Integer, LRUNode> map = new HashMap<Integer, LRUNode>();
    LRUNode head=null;
    LRUNode end=null;
 
    public Q16_LRUcache(int capacity) {
        this.capacity = capacity;
    }
 
    public int get(int key) {
        if(map.containsKey(key)){
        	LRUNode n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
 
        return -1;
    }
 
    public void remove(LRUNode n){
        if(n.pre!=null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }
 
        if(n.next!=null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }
 
    }
 
    public void setHead(LRUNode n){
        n.next = head;
        n.pre = null;
 
        if(head!=null)
            head.pre = n;
 
        head = n;
 
        if(end ==null)
            end = head;
    }
 
    public void set(int key, int value) {
        if(map.containsKey(key)){
        	LRUNode old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
        	LRUNode created = new LRUNode(key, value);
            if(map.size()>=capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);
 
            }else{
                setHead(created);
            }    
 
            map.put(key, created);
        }
    }
	public static void main(String[] args) {
		Q16_LRUcache obj = new Q16_LRUcache(4);
		//obj.set();

	}

}
