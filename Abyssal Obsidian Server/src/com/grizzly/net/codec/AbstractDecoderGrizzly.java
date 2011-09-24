package com.grizzly.net.codec;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;

/**
 * An abstract decoder to represent
 * decoding in the Grizzly Server.
 * 
 * @author Joshua Rodrigues
 * @since Sep 18, 2011 11:56:25 PM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public abstract class AbstractDecoderGrizzly {

	/**
	 * Decode an Object from an incoming
	 * client packet.
	 * 
	 * @return
	 * 			The decoded Object.
	 */
	public abstract Object decode();
}