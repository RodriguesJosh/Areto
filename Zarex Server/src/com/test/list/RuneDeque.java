/**
 * 
 */
package com.test.list;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

/**
 * 
 * @author Joshua Rodrigues
 * @param <E>
 * 			The type of deque.
 * @since Sep 20, 2011 10:56:33 AM
 */
public class RuneDeque<E> implements Deque<E>, Collection<E>, Iterable<E>  {

	/**
	 * 
	 */
	private Object[] objects;

	/* (non-Javadoc)
	 * @see java.util.Collection#add(java.lang.Object)
	 */
	@Override
	public boolean add(E e) {
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#addAll(java.util.Collection)
	 */
	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#clear()
	 */
	@Override
	public void clear() {
		return;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object o) {
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#containsAll(java.util.Collection)
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		return super.equals(object);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#iterator()
	 */
	@Override
	public Iterator<E> iterator() {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object o) {
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#removeAll(java.util.Collection)
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#retainAll(java.util.Collection)
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#size()
	 */
	@Override
	public int size() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#toArray()
	 */
	@Override
	public Object[] toArray() {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#toArray(T[])
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#addFirst(java.lang.Object)
	 */
	@Override
	public void addFirst(E e) {
		return;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#addLast(java.lang.Object)
	 */
	@Override
	public void addLast(E e) {
		return;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#descendingIterator()
	 */
	@Override
	public Iterator<E> descendingIterator() {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#element()
	 */
	@Override
	public E element() {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#getFirst()
	 */
	@Override
	public E getFirst() {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#getLast()
	 */
	@Override
	public E getLast() {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#offer(java.lang.Object)
	 */
	@Override
	public boolean offer(E e) {
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#offerFirst(java.lang.Object)
	 */
	@Override
	public boolean offerFirst(E e) {
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#offerLast(java.lang.Object)
	 */
	@Override
	public boolean offerLast(E e) {
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#peek()
	 */
	@Override
	public E peek() {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#peekFirst()
	 */
	@Override
	public E peekFirst() {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#peekLast()
	 */
	@Override
	public E peekLast() {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#poll()
	 */
	@Override
	public E poll() {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#pollFirst()
	 */
	@Override
	public E pollFirst() {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#pollLast()
	 */
	@Override
	public E pollLast() {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#pop()
	 */
	@Override
	public E pop() {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#push(java.lang.Object)
	 */
	@Override
	public void push(E e) {
		return;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#remove()
	 */
	@Override
	public E remove() {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#removeFirst()
	 */
	@Override
	public E removeFirst() {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#removeFirstOccurrence(java.lang.Object)
	 */
	@Override
	public boolean removeFirstOccurrence(Object o) {
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#removeLast()
	 */
	@Override
	public E removeLast() {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Deque#removeLastOccurrence(java.lang.Object)
	 */
	@Override
	public boolean removeLastOccurrence(Object o) {
		return false;
	}

	/**
	 * 
	 * @param objects
	 * 			The objects to set.
	 */
	public void setObjects(Object[] objects) {
		this.objects = objects;
	}

	/**
	 * 
	 * @return objects
	 * 			Returns the objects to get.
	 */
	public Object[] getObjects() {
		return this.objects;
	}
}