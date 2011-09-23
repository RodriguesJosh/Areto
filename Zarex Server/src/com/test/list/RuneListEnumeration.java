package com.test.list;

import java.util.Enumeration;

/**
 * 
 * @author Joshua Rodrigues
 * @param <E>
 * 			The type of Object to enumerate.
 * @since Sep 19, 2011 10:28:53 PM
 */
public class RuneListEnumeration<E extends Object> implements Enumeration<E> {

	/* (non-Javadoc)
	 * @see java.util.Enumeration#hasMoreElements()
	 */
	@Override
	public boolean hasMoreElements() {
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Enumeration#nextElement()
	 */
	@Override
	public E nextElement() {
		return null;
	}
}