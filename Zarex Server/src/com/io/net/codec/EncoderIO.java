package com.io.net.codec;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;

/**
 * Encodes the packet for the player and
 * then sends it to the client.
 * 
 * @author Josh Rodrigues
 * @since September 18, 2011
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class EncoderIO extends AbstractDecoderIO {

	/*
	 * (non-Javadoc)
	 * @see com.io.net.codec.AbstractDecoderIO#decode()
	 */
	@Override
	public Object decode() {
		return null;
	}
}