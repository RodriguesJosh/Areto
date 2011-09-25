package com.netty.annotations;

/**
 * A class that uses this annotation will be
 * warned that editing is not needed anymore.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 1:27:26 PM
 */
public @interface Finished {

	/**
	 * The type of annotation for this
	 * annotation.
	 */
	AnnotationType getAnnotationType();
}