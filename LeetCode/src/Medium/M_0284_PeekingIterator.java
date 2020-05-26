package Medium;

import java.util.*;
/*
 * https://leetcode.com/problems/peeking-iterator/
 */

public class M_0284_PeekingIterator<E> implements Iterator<E> {

	private final Iterator<? extends E> iterator;
	private boolean noSuchElement;
	private E peekedElement;

	public M_0284_PeekingIterator(Iterator<E> iterator) {
		this.iterator = iterator;
		advanceIter();
	}

	// Returns the next element in the iteration without advancing the iterator.
	public E peek() {
		return peekedElement;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public E next() {
		if (noSuchElement) {
			throw new NoSuchElementException();
		}
		E temp = peekedElement;
		advanceIter();

		return temp;
	}

	@Override
	public boolean hasNext() {
		return !noSuchElement;
	}

	public void advanceIter() {
		if (iterator.hasNext()) {
			peekedElement = iterator.next();
		} else {
			noSuchElement = true;
		}
	}

	public static void main(String[] args) {
		ArrayList names = new ArrayList();
		names.add("1");
		names.add("2");
		names.add("3");
		Iterator it = names.iterator();

		M_0284_PeekingIterator<String> peekingIteratorObj = new M_0284_PeekingIterator(it);
		System.out.println(peekingIteratorObj.next());
		System.out.println(peekingIteratorObj.peek());
		System.out.println(peekingIteratorObj.next());
		System.out.println(peekingIteratorObj.next());
		System.out.println(peekingIteratorObj.hasNext());
	}
}
