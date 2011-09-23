package com.io.net.codec;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;

/**
 * Sets up the login protocol so we
 * can actually play the Netty Server.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 12:14:54 AM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class LoginIO extends AbstractDecoderIO {

	/*
	 * (non-Javadoc)
	 * @see com.io.net.codec.AbstractDecoderIO#decode()
	 */
	@Override
	public Object decode() {
		return null;
	}
}