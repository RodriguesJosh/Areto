package com.netty;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

/**
 * Test anything you want here! Results
 * will be put down underneath this!
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 6:29:10 PM
 */
public class Test {

	/**
	 * The amount of iterations to occur
	 * for the array and ArrayList.
	 */
	public static final int MAX_ITERATIONS = 2000;

	/**
	 * The main method to execute upon startup
	 * of this application.
	 * 
	 * @param args
	 * 			The program's arguments.
	 */
	public static void main(String[] args) {
		Test.loopArray();
		System.out.println();
		Test.loopArrayList();
		System.out.println();
		Test.loopLinkedList();
		System.out.println();
		Test.loopVectorList();
		System.out.println();
		Test.iteratorArrayList();
		System.out.println();
		Test.iteratorLinkedList();
		System.out.println();
		Test.iteratorVectorList();
		System.out.println();
		Test.forEachLoopArrayList();
		System.out.println();
		Test.forEachLoopLinkedList();
		System.out.println();
		Test.forEachLoopVectorList();
	}

	/**
	 * 
	 */
	public static void loopArray() {
		Integer[] array = new Integer[Test.MAX_ITERATIONS];

		/** Add things to array. */

		long addNanoStartTime = System.nanoTime();
		for (int i = 0; i < Test.MAX_ITERATIONS; i++) {
			array[i] = new Integer(i);
		}
		long addNanoEndTime = System.nanoTime();
		long totalAddNanoTime = addNanoEndTime - addNanoStartTime;
		System.out.println("Add Array: " + (totalAddNanoTime / 1000000.0) + "ms");

		/** Get things from array. */

		long getNanoStartTime = System.nanoTime();
		Integer j = null;
		for (int i = 0; i < Test.MAX_ITERATIONS; i++) {
			j = array[i];
		}
		if (j == null) {
			return;
		}
		long getNanoEndTime = System.nanoTime();
		long totalGetNanoTime = getNanoEndTime - getNanoStartTime;
		System.out.println("Index: " + j.intValue() + " Get Array: " + (totalGetNanoTime / 1000000.0) + "ms");

		/** Remove things from array. */

		long removeNanoStartTime = System.nanoTime();
		for (int i = 0; i < Test.MAX_ITERATIONS; i++) {
			array[i] = null;
		}
		long removeNanoEndTime = System.nanoTime();
		long totalRemoveNanoTime = removeNanoEndTime - removeNanoStartTime;
		System.out.println("Remove Array: " + (totalRemoveNanoTime / 1000000.0) + "ms");
	}

	/**
	 * 
	 */
	public static void loopArrayList() {
		List<Integer> arrayList = new ArrayList<Integer>();

		/** Add things to array list. */

		long addNanoStartTime = System.nanoTime();
		for (int i = 0; i < Test.MAX_ITERATIONS; i++) {
			arrayList.add(new Integer(i));
		}
		long addNanoEndTime = System.nanoTime();
		long totalAddNanoTime = addNanoEndTime - addNanoStartTime;
		System.out.println("Add ArrayList: " + (totalAddNanoTime / 1000000.0) + "ms");

		/** Get things from array list. */

		long getNanoStartTime = System.nanoTime();
		for (int i = 0; i < Test.MAX_ITERATIONS; i++) {
			arrayList.get(i);
		}
		long getNanoEndTime = System.nanoTime();
		long totalGetNanoTime = getNanoEndTime - getNanoStartTime;
		System.out.println("Get ArrayList: " + (totalGetNanoTime / 1000000.0) + "ms");

		/** Remove things from array list. */

		long removeNanoStartTime = System.nanoTime();
		for (int i = 0; i < Test.MAX_ITERATIONS; i++) {
			if (i == 1000) {
				break;
			}
			arrayList.remove(i);
		}
		long removeNanoEndTime = System.nanoTime();
		long totalRemoveNanoTime = removeNanoEndTime - removeNanoStartTime;
		System.out.println("Remove ArrayList: " + (totalRemoveNanoTime / 1000000.0) + "ms");
	}

	/**
	 * 
	 */
	public static void loopLinkedList() {
		List<Integer> linkedList = new LinkedList<Integer>();

		/** Add things to linked list. */

		long addNanoStartTime = System.nanoTime();
		for (int i = 0; i < Test.MAX_ITERATIONS; i++) {
			linkedList.add(new Integer(i));
		}
		long addNanoEndTime = System.nanoTime();
		long totalAddNanoTime = addNanoEndTime - addNanoStartTime;
		System.out.println("Add LinkedList: " + (totalAddNanoTime / 1000000.0) + "ms");

		/** Get things from linked list. */

		long getNanoStartTime = System.nanoTime();
		for (int i = 0; i < Test.MAX_ITERATIONS; i++) {
			linkedList.get(i);
		}
		long getNanoEndTime = System.nanoTime();
		long totalGetNanoTime = getNanoEndTime - getNanoStartTime;
		System.out.println("Get LinkedList: " + (totalGetNanoTime / 1000000.0) + "ms");

		/** Remove things from linked list. */

		long removeNanoStartTime = System.nanoTime();
		for (int i = 0; i < Test.MAX_ITERATIONS; i++) {
			if (i == 1000) {
				break;
			}
			linkedList.remove(i);
		}
		long removeNanoEndTime = System.nanoTime();
		long totalRemoveNanoTime = removeNanoEndTime - removeNanoStartTime;
		System.out.println("Remove LinkedList: " + (totalRemoveNanoTime / 1000000.0) + "ms");
	}

	/**
	 * 
	 */
	public static void loopVectorList() {
		List<Integer> vectorList = new Vector<Integer>();

		/** Add things to linked list. */

		long addNanoStartTime = System.nanoTime();
		for (int i = 0; i < Test.MAX_ITERATIONS; i++) {
			vectorList.add(new Integer(i));
		}
		long addNanoEndTime = System.nanoTime();
		long totalAddNanoTime = addNanoEndTime - addNanoStartTime;
		System.out.println("Add Vector: " + (totalAddNanoTime / 1000000.0) + "ms");

		/** Get things from linked list. */

		long getNanoStartTime = System.nanoTime();
		for (int i = 0; i < Test.MAX_ITERATIONS; i++) {
			vectorList.get(i);
		}
		long getNanoEndTime = System.nanoTime();
		long totalGetNanoTime = getNanoEndTime - getNanoStartTime;
		System.out.println("Get Vector: " + (totalGetNanoTime / 1000000.0) + "ms");

		/** Remove things from linked list. */

		long removeNanoStartTime = System.nanoTime();
		for (int i = 0; i < Test.MAX_ITERATIONS; i++) {
			if (i == 1000) {
				break;
			}
			vectorList.remove(i);
		}
		long removeNanoEndTime = System.nanoTime();
		long totalRemoveNanoTime = removeNanoEndTime - removeNanoStartTime;
		System.out.println("Remove Vector: " + (totalRemoveNanoTime / 1000000.0) + "ms");
	}

	/**
	 * 
	 */
	public static void loopArrayDequeList() {
		Deque<Integer> arrayDeque = new ArrayDeque<Integer>();

		/** Add things to array deque list. */

		long addNanoStartTime = System.nanoTime();
		for (int i = 0; i < Test.MAX_ITERATIONS; i++) {
			arrayDeque.add(new Integer(i));
		}
		long addNanoEndTime = System.nanoTime();
		long totalAddNanoTime = addNanoEndTime - addNanoStartTime;
		System.out.println("Add Vector: " + (totalAddNanoTime / 1000000.0) + "ms");

		/** Get things from array deque list. */

		long getNanoStartTime = System.nanoTime();
		// for (int i = 0; i < Test.MAX_ITERATIONS; i++) {
		// arrayDeque.
		// }
		long getNanoEndTime = System.nanoTime();
		long totalGetNanoTime = getNanoEndTime - getNanoStartTime;
		System.out.println("Get Vector: " + (totalGetNanoTime / 1000000.0) + "ms");

		/** Remove things from array deque list. */

		long removeNanoStartTime = System.nanoTime();
		for (int i = 0; i < Test.MAX_ITERATIONS; i++) {
			if (i == 1000) {
				break;
			}
			arrayDeque.remove(new Integer(i));
		}
		long removeNanoEndTime = System.nanoTime();
		long totalRemoveNanoTime = removeNanoEndTime - removeNanoStartTime;
		System.out.println("Remove Vector: " + (totalRemoveNanoTime / 1000000.0) + "ms");
	}

	/**
	 * 
	 */
	public static void iteratorArrayList() {
		List<Integer> arrayList = new ArrayList<Integer>();

		/** Add things to array list. */

		long addNanoStartTime = System.nanoTime();
		for (Iterator<Integer> integerIterator = arrayList.iterator(); integerIterator.hasNext();) {
			Integer integer = integerIterator.next();
			arrayList.add(integer);
		}
		long addNanoEndTime = System.nanoTime();
		long totalAddNanoTime = addNanoEndTime - addNanoStartTime;
		System.out.println("Add ArrayList Iterator: " + (totalAddNanoTime / 1000000.0) + "ms");

		/** Get things from array list. */

		long getNanoStartTime = System.nanoTime();
		for (ListIterator<Integer> integerIterator = (ListIterator<Integer>) arrayList.iterator(); integerIterator.hasNext();) {
			arrayList.get(integerIterator.nextIndex());
		}
		long getNanoEndTime = System.nanoTime();
		long totalGetNanoTime = getNanoEndTime - getNanoStartTime;
		System.out.println("Get ArrayList Iterator: " + (totalGetNanoTime / 1000000.0) + "ms");

		/** Remove things from array list. */

		long removeNanoStartTime = System.nanoTime();
		for (Iterator<Integer> integerIterator = arrayList.iterator(); integerIterator.hasNext();) {
			Integer integer = integerIterator.next();
			arrayList.remove(integer);
		}
		long removeNanoEndTime = System.nanoTime();
		long totalRemoveNanoTime = removeNanoEndTime - removeNanoStartTime;
		System.out.println("Remove ArrayList Iterator: " + (totalRemoveNanoTime / 1000000.0) + "ms");
	}

	/**
	 * 
	 */
	public static void iteratorLinkedList() {
		List<Integer> linkedList = new LinkedList<Integer>();

		/** Add things to linked list. */

		long addNanoStartTime = System.nanoTime();
		for (Iterator<Integer> integerIterator = linkedList.iterator(); integerIterator.hasNext();) {
			Integer integer = integerIterator.next();
			linkedList.add(integer);
		}
		long addNanoEndTime = System.nanoTime();
		long totalAddNanoTime = addNanoEndTime - addNanoStartTime;
		System.out.println("Add LinkedList Iterator: " + (totalAddNanoTime / 1000000.0) + "ms");

		/** Get things from linked list. */

		long getNanoStartTime = System.nanoTime();
		for (ListIterator<Integer> integerIterator = (ListIterator<Integer>) linkedList.iterator(); integerIterator.hasNext();) {
			linkedList.get(integerIterator.nextIndex());
		}
		long getNanoEndTime = System.nanoTime();
		long totalGetNanoTime = getNanoEndTime - getNanoStartTime;
		System.out.println("Get LinkedList Iterator: " + (totalGetNanoTime / 1000000.0) + "ms");

		/** Remove things from linked list. */

		long removeNanoStartTime = System.nanoTime();
		for (Iterator<Integer> integerIterator = linkedList.iterator(); integerIterator.hasNext();) {
			Integer integer = integerIterator.next();
			linkedList.remove(integer);
		}
		long removeNanoEndTime = System.nanoTime();
		long totalRemoveNanoTime = removeNanoEndTime - removeNanoStartTime;
		System.out.println("Remove LinkedList Iterator: " + (totalRemoveNanoTime / 1000000.0) + "ms");
	}

	/**
	 * 
	 */
	public static void iteratorVectorList() {
		List<Integer> vectorList = new Vector<Integer>();

		/** Add things to vector list. */

		long addNanoStartTime = System.nanoTime();
		for (Iterator<Integer> integerIterator = vectorList.iterator(); integerIterator.hasNext();) {
			Integer integer = integerIterator.next();
			vectorList.add(integer);
		}
		long addNanoEndTime = System.nanoTime();
		long totalAddNanoTime = addNanoEndTime - addNanoStartTime;
		System.out.println("Add Vector Iterator: " + (totalAddNanoTime / 1000000.0) + "ms");

		/** Get things from vector list. */

		long getNanoStartTime = System.nanoTime();
		for (ListIterator<Integer> integerIterator = (ListIterator<Integer>) vectorList.iterator(); integerIterator.hasNext();) {
			vectorList.get(integerIterator.nextIndex());
		}
		long getNanoEndTime = System.nanoTime();
		long totalGetNanoTime = getNanoEndTime - getNanoStartTime;
		System.out.println("Get Vector Iterator: " + (totalGetNanoTime / 1000000.0) + "ms");

		/** Remove things from vector list. */

		long removeNanoStartTime = System.nanoTime();
		for (Iterator<Integer> integerIterator = vectorList.iterator(); integerIterator.hasNext();) {
			Integer integer = integerIterator.next();
			vectorList.remove(integer);
		}
		long removeNanoEndTime = System.nanoTime();
		long totalRemoveNanoTime = removeNanoEndTime - removeNanoStartTime;
		System.out.println("Remove Vector Iterator: " + (totalRemoveNanoTime / 1000000.0) + "ms");
	}

	/**
	 * 
	 */
	public static void forEachLoopArrayList() {
		List<Integer> arrayList = new ArrayList<Integer>();

		/** Add things to array list. */

		long addNanoStartTime = System.nanoTime();
		for (Integer integer : arrayList) {
			arrayList.add(integer);
		}
		long addNanoEndTime = System.nanoTime();
		long totalAddNanoTime = addNanoEndTime - addNanoStartTime;
		System.out.println("Add For Each ArrayList: " + (totalAddNanoTime / 1000000.0) + "ms");

		/** Get things from array list. */

		long getNanoStartTime = System.nanoTime();
		// int i = 0;
		// for (Integer integer : arrayList) {
		// 	arrayList.get(i);
		// 	i++;
		// }
		long getNanoEndTime = System.nanoTime();
		long totalGetNanoTime = getNanoEndTime - getNanoStartTime;
		System.out.println("Get For Each ArrayList: " + (totalGetNanoTime / 1000000.0) + "ms");

		/** Remove things from array list. */

		// i = 0;
		long removeNanoStartTime = System.nanoTime();
		// for (Integer integer : arrayList) {
		// 	if (arrayList.get(i).intValue() == 1000) {
		// 		break;
		// 	}
		// 	arrayList.remove(i);
		// 	i++;
		// }
		long removeNanoEndTime = System.nanoTime();
		long totalRemoveNanoTime = removeNanoEndTime - removeNanoStartTime;
		System.out.println("Remove For Each ArrayList: " + (totalRemoveNanoTime / 1000000.0) + "ms");
	}

	/**
	 * 
	 */
	public static void forEachLoopLinkedList() {
		List<Integer> linkedList = new LinkedList<Integer>();

		/** Add things to linked list. */

		long addNanoStartTime = System.nanoTime();
		for (Integer integer : linkedList) {
			linkedList.add(integer);
		}
		long addNanoEndTime = System.nanoTime();
		long totalAddNanoTime = addNanoEndTime - addNanoStartTime;
		System.out.println("Add For Each LinkedList: " + (totalAddNanoTime / 1000000.0) + "ms");

		/** Get things from linked list. */

		int i = 0;
		long getNanoStartTime = System.nanoTime();
		// for (Integer integer : linkedList) {
		// 	linkedList.get(i);
		// 	i++;
		// }
		long getNanoEndTime = System.nanoTime();
		long totalGetNanoTime = getNanoEndTime - getNanoStartTime;
		System.out.println("Get For Each LinkedList: " + (totalGetNanoTime / 1000000.0) + "ms");

		/** Remove things from linked list. */

		i = 0;
		long removeNanoStartTime = System.nanoTime();
		for (Integer integer : linkedList) {
			if (linkedList.get(i).intValue() == 1000) {
				break;
			}
			linkedList.remove(integer);
		}
		long removeNanoEndTime = System.nanoTime();
		long totalRemoveNanoTime = removeNanoEndTime - removeNanoStartTime;
		System.out.println("Remove For Each LinkedList: " + (totalRemoveNanoTime / 1000000.0) + "ms");
	}

	/**
	 * 
	 */
	public static void forEachLoopVectorList() {
		List<Integer> vectorList = new Vector<Integer>();

		/** Add things to vector list. */

		long addNanoStartTime = System.nanoTime();
		for (Integer integer : vectorList) {
			vectorList.add(integer);
		}
		long addNanoEndTime = System.nanoTime();
		long totalAddNanoTime = addNanoEndTime - addNanoStartTime;
		System.out.println("Add For Each Vector: " + (totalAddNanoTime / 1000000.0) + "ms");

		/** Get things from vector list. */

		long getNanoStartTime = System.nanoTime();
		int i = 0;
		// for (Integer integer : vectorList) {
		// 	vectorList.get(i);
		// 	i++;
		// }
		long getNanoEndTime = System.nanoTime();
		long totalGetNanoTime = getNanoEndTime - getNanoStartTime;
		System.out.println("Get For Each Vector: " + (totalGetNanoTime / 1000000.0) + "ms");

		/** Remove things from vector list. */
		i = 0;
		long removeNanoStartTime = System.nanoTime();
		for (Integer integer : vectorList) {
			if (vectorList.get(i).intValue() == 1000) {
				break;
			}
			vectorList.remove(integer);
		}
		long removeNanoEndTime = System.nanoTime();
		long totalRemoveNanoTime = removeNanoEndTime - removeNanoStartTime;
		System.out.println("Remove For Each Vector: " + (totalRemoveNanoTime / 1000000.0) + "ms");
	}
}