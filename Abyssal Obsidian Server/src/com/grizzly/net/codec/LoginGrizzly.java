package com.grizzly.net.codec;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;

/**
 * Sets up the login protocol so we
 * can actually play the Netty Server.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 12:04:29 AM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class LoginGrizzly extends AbstractDecoderGrizzly {

	/*
	 * (non-Javadoc)
	 * @see com.grizzly.net.codec.AbstractDecoderGrizzly#decode()
	 */
	@Override
	public Object decode() {
		return null;
	}
}