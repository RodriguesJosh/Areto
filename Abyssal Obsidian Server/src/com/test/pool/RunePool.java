package com.test.pool;

/**
 * 
 * @author Joshua Rodrigues
 * @param <E>
 * 			The type of pool you wish to create.
 * @since Sep 20, 2011 12:33:14 AM
 */
public class RunePool<E> {

	/**
	 * 
	 */
	private E[] elements;

	/**
	 * 
	 * @param elements
	 * 			The elements to set.
	 */
	public void setElements(E[] elements) {
		this.elements = elements;
	}

	/**
	 * 
	 * @return elements
	 * 			Returns the elements to get.
	 */
	public E[] getElements() {
		return this.elements;
	}
}