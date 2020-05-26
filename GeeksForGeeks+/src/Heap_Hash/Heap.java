package Heap_Hash;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
 * http://www.youtube.com/watch?v=W81Qzuz4qH0&spfreload=10
 * http://geeksquiz.com/binary-heap/
 */
public class Heap<T extends Comparable<T>> {

	ArrayList<T> items;

	public Heap(){
		items = new ArrayList<T>();
	}

	/*
	 * When ever we insert a new elem we compare the inserted elem with its parent if the parent is small then swap as
	 * we want the max elem to be at top
	 */

	private void shiftUp(){
		if(items.size() == 0){
			return;
		}
		int k = items.size() - 1, parentIndx;
		while(k > 0){
			parentIndx = (k-1)/2;
			T item = items.get(k);
			T parent = items.get(parentIndx);
			if(item.compareTo(parent) > 0){
				swap(k,parentIndx);
				k = parentIndx;
			}
			else{
				break;
			}
		}
	}

	/*
	 * Here whenevr we delete a elem we move the last elem from to top and then compare the last elem ie now at top with its
	 * child if max of left and right child is greater then the top elem then we swap.
	 */
	private void shiftDown(){
		if(items.size() == 0){
			return;
		}
		int k = 0, leftChildIndx = (2*k+1), rightChildIndx = (2*k+2);
		while(leftChildIndx < (items.size()-1)){

			leftChildIndx = (2*k+1);
			rightChildIndx = (2*k+2);

			T item = items.get(k);
			T leftChild = items.get(leftChildIndx);

			if(rightChildIndx < (items.size()-1)){
				T rightChild = items.get(rightChildIndx);
				if(leftChild.compareTo(rightChild) >= 0){
					if(item.compareTo(leftChild) < 0){
						swap(k,leftChildIndx);
						k = leftChildIndx;
					}
					else
						break;
				}
				else if(leftChild.compareTo(rightChild) < 0){
					if(item.compareTo(rightChild) < 0){
						swap(k,rightChildIndx);
						k = rightChildIndx;
					}
					else
						break;
				}
			}
			else{
				if(item.compareTo(leftChild) < 0){
					swap(k,leftChildIndx);
					k = leftChildIndx;
				}
				else
					break;
			}
		}
	}

	public void insert(T x){
		items.add(x);
		shiftUp();
	}

	/*
	 * Here we just delete the top elem and insert the last elem to the top and then check elem with its child and again bring the max elem
	 * from the heap to top.
	 */
	public T delete() throws NoSuchElementException{
		if(items.size() == 0){
			throw new NoSuchElementException("Heap Empty");
		}
		if (items.size() == 1) {
			return items.remove(0);
		}
		T lastItem = items.remove(items.size()-1);
		T firstItem = items.get(0);
		items.set(0,lastItem);
		shiftDown();
		return firstItem;
	}

	public void swap(int a, int b){
		T temp = items.get(a);
		items.set(a, items.get(b));
		items.set(b,temp);
	}

	public boolean isEmpty() {
		return items.isEmpty();

	}

	@Override
    public String toString() {
		return items.toString();
	}

	public static void main(String[] args) {
		Heap<Integer> hp = new Heap<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter next int, 'done' to stop: ");
		String line = sc.next();
		while (!line.equals("done")) {
			hp.insert(Integer.parseInt(line));
			System.out.println(hp);
			System.out.print("Enter next int, 'done' to stop: ");
			line = sc.next();
		}

		while (!hp.isEmpty()) {
			int max = hp.delete();
			System.out.println("Max: "+max + " From: " + hp);
		}

	}

}
