package com.io.net.codec;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;

/**
 * The decoder to decode packets sent from
 * the client.
 * 
 * @author Josh Rodrigues
 * @since September 18, 2011
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class DecoderIO extends AbstractDecoderIO {

	/*
	 * (non-Javadoc)
	 * @see com.io.net.codec.AbstractDecoderIO#decode()
	 */
	@Override
	public Object decode() {
		return null;
	}
}