package com.test.map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Joshua Rodrigues
 * @param <K>
 * 			The key for the map.
 * @param <V>
 * 			The value associated with the
 * 			key.
 * @since Sep 20, 2011 12:19:54 AM
 */
public class RuneMap<K, V> implements Map<K, V> {

	/**
	 * 
	 */
	private Object[] objects;

	/**
	 * 
	 */
	private int size;

	/* (non-Javadoc)
	 * @see java.util.Map#clear()
	 */
	@Override
	public void clear() {
		return;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(Object object) {
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#containsValue(java.lang.Object)
	 */
	@Override
	public boolean containsValue(Object object) {
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#entrySet()
	 */
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		return super.equals(object);
	}

	/* (non-Javadoc)
	 * @see java.util.Map#get(java.lang.Object)
	 */
	@Override
	public V get(Object object) {
		return null;
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
	 * @see java.util.Map#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#keySet()
	 */
	@Override
	public Set<K> keySet() {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V put(K k, V v) {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	@Override
	public void putAll(Map<? extends K, ? extends V> map) {
		return;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	@Override
	public V remove(Object object) {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#size()
	 */
	@Override
	public int size() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#values()
	 */
	@Override
	public Collection<V> values() {
		return null;
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