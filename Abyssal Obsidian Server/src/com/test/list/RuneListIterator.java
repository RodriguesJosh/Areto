package com.test.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * 
 * @author Joshua Rodrigues
 * @param <E>
 * 			The type of Object we wish to iterate
 * 			over.
 * @since Sep 19, 2011 9:38:47 PM
 */
public class RuneListIterator<E extends Object> implements Iterator<E> {

	/**
	 * The entities.
	 */
	private Object[] objects;

	/**
	 * The entity list.
	 */
	private RuneList<E> runeList;

	/**
	 * The previous index.
	 */
	private int previousPosition = -1;

	/**
	 * The current index.
	 */
	private int currentPosition = 0;

	/**
	 * The size of the list.
	 */
	private int size;

	/**
	 * Constructs a new RuneListIterator for
	 * the rune list.
	 * 
	 * @param runeList
	 * 			The rune list to iterate.
	 */
	public RuneListIterator(RuneList<E> runeList) {
		this.setRuneList(runeList);
		this.setObjects(runeList.toArray(new Object[0]));
		this.setSize(this.getObjects().length);
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return this.getCurrentPosition() < this.getSize();
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	@Override
	public E next() {
		if (!this.hasNext()) {
			throw new NoSuchElementException();
		}
		this.setPreviousPosition(this.currentPosition++);
		// Object object = this.getObjects()[this.getPreviousPosition()];
		// return (E) object;
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove() {
		if (this.getPreviousPosition() == -1) {
			throw new IllegalStateException();
		}
		this.getRuneList().remove(this.getObjects()[this.getPreviousPosition()]);
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

	/**
	 * 
	 * @param runeList
	 * 			The runeList to set.
	 */
	public void setRuneList(RuneList<E> runeList) {
		this.runeList = runeList;
	}

	/**
	 * 
	 * @return runeList
	 * 			Returns the runeList to get.
	 */
	public RuneList<E> getRuneList() {
		return this.runeList;
	}

	/**
	 * 
	 * @param previousPosition
	 * 			The previousPosition to set.
	 */
	public void setPreviousPosition(int previousPosition) {
		this.previousPosition = previousPosition;
	}

	/**
	 * 
	 * @return previousPosition
	 * 			Returns the previousPosition to get.
	 */
	public int getPreviousPosition() {
		return this.previousPosition;
	}

	/**
	 * 
	 * @param currentPosition
	 * 			The currentPosition to set.
	 */
	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

	/**
	 * 
	 * @return currentPosition
	 * 			Returns the currentPosition to get.
	 */
	public int getCurrentPosition() {
		return this.currentPosition;
	}

	/**
	 * 
	 * @param size
	 * 			The size to set.
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * 
	 * @return size
	 * 			Returns the size to get.
	 */
	public int getSize() {
		return this.size;
	}
}