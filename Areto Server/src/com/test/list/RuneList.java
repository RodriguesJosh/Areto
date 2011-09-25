package com.test.list;

import java.util.Collection;
import java.util.Iterator;

/**
 * 
 * 
 * @author Joshua Rodrigues
 * @param <E>
 * 			The type of element used in this list.
 * @since Sep 19, 2011 9:17:13 PM
 */
public class RuneList<E> implements Collection<E>, Iterable<E> {

	/**
	 * 
	 */
	private Object[] objects;

	/**
	 * 
	 */
	private int size;

	/**
	 * Default constructor to create 10 Objects
	 * for the list to use.
	 */
	public RuneList() {
		this.setObjects(new Object[10]);
	}

	/**
	 * 
	 * 
	 * @param capacity
	 * 			The maximum amount of Objects
	 * 			allowed in this list.
	 */
	public RuneList(int capacity) {
		this.setObjects(new Object[capacity + 1]);
	}

	/**
	 * 
	 * 
	 * @param position
	 * 			The position inside the array of
	 * 			Objects.
	 * @return
	 * 			The Object in the specified position.
	 */
	public Object getObject(int position) {
		if ((position <= 0) || (position >= this.getObjects().length)) {
			throw new IndexOutOfBoundsException("Position: " + position);
		}
		return this.getObjects()[position];
	}

	/**
	 * 
	 * 
	 * @param object
	 * 			The Object to get the index inside the
	 * 			array.
	 * @return
	 * 			i if we found the index, -1 otherwise.
	 */
	public int getPosition(Object object) {
		for (int i = 1; i < this.getObjects().length; i++) {
			if (this.getObjects()[i] == object) {
				return i;
			}
		}
		return -1;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#add(java.lang.Object)
	 */
	@Override
	public boolean add(E object) {
		int position = this.getPosition(object);
		if (position == -1) {
			return false;
		}
		this.getObjects()[position] = object;
		int size = this.getSize();
		size++;
		this.setSize(size);
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#addAll(java.util.Collection)
	 */
	@Override
	public boolean addAll(Collection<? extends E> objects) {
		boolean isAdded = false;
		for (E object : objects) {
			if (this.add(object)) {
				isAdded = true;
			}
		}
		return isAdded;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#clear()
	 */
	@Override
	public void clear() {
		for (int i = 1; i < this.getObjects().length; i++) {
			this.getObjects()[i] = null;
		}
		this.setSize(0);
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object object) {
		for (int i = 1; i < this.getObjects().length; i++) {
			if (this.getObjects()[i] == object) {
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#containsAll(java.util.Collection)
	 */
	@Override
	public boolean containsAll(Collection<?> objects) {
		boolean isContained = true;
		for (Object object : objects) {
			if (this.contains(object)) {
				isContained = false;
			}
		}
		return isContained;
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
		return this.getSize() <= 0;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#iterator()
	 */
	@Override
	public Iterator<E> iterator() {
		return new RuneListIterator<E>(this);
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object object) {
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#removeAll(java.util.Collection)
	 */
	@Override
	public boolean removeAll(Collection<?> objects) {
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#retainAll(java.util.Collection)
	 */
	@Override
	public boolean retainAll(Collection<?> objects) {
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
	public <T> T[] toArray(T[] t) {
		return null;
	}

	/**
	 * 
	 * 
	 * @param objects
	 * 			The objects to set.
	 */
	public void setObjects(Object[] objects) {
		this.objects = objects;
	}

	/**
	 * 
	 * 
	 * @return objects
	 * 			Returns the objects to get.
	 */
	public Object[] getObjects() {
		return this.objects;
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