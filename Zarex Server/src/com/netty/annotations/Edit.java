package com.netty.annotations;

/**
 * A class that uses this annotation will need some
 * editing done in order to make it a complete and
 * useable class.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 1:27:35 PM
 */
public @interface Edit {

	/**
	 * The type of annotation for this
	 * annotation.
	 */
	AnnotationType getAnnotationType();
}